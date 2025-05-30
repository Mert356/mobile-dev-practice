package com.example.finalprojectfoodapp.ui.viewmodel

import androidx.lifecycle.*
import com.example.finalprojectfoodapp.data.entity.SepetYemek
import com.example.finalprojectfoodapp.data.entity.Yemek
import com.example.finalprojectfoodapp.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CartFragmentViewModel @Inject constructor(
    private val repo: YemeklerRepository
) : ViewModel() {

    private val _sepetYemekler = MutableLiveData<List<SepetYemek>>()
    val sepetYemekler: LiveData<List<SepetYemek>> = _sepetYemekler

    val kullaniciAdi = "Mert Çelik"

    fun sepeteEkle(
        yemek: Yemek,
        adet: Int
    ) {
        viewModelScope.launch {
            repo.sepeteYemekEkle(
                yemekAdi = yemek.ad,
                yemekResimAdi = yemek.resimAdi,
                yemekFiyat = yemek.fiyat.toInt(),
                yemekAdet = adet,
                kullaniciAdi = kullaniciAdi
            )
            getSepet()
        }
    }

    fun sepettenCikar(sepetYemekId: Int) {
        viewModelScope.launch {
            repo.sepettenYemekSil(sepetYemekId, kullaniciAdi)
            getSepet()
        }
    }

    fun getSepet() {
        viewModelScope.launch {
            try {
                val liste = repo.getSepettekiYemekler(kullaniciAdi)
                _sepetYemekler.value = liste ?: emptyList()
            } catch (e: Exception) {
                _sepetYemekler.value = emptyList()
            }
        }
    }


    fun sepetiTemizle() {
        val currentSepet = _sepetYemekler.value ?: return
        viewModelScope.launch {
            currentSepet.forEach {
                repo.sepettenYemekSil(it.sepetYemekId, kullaniciAdi)
            }
            getSepet()
        }
    }

    fun getToplamFiyat(): Int {
        return _sepetYemekler.value?.sumOf {
            (it.yemekFiyat ?: 0) * (it.yemekSiparisAdet ?: 0)
        } ?: 0
    }

}
