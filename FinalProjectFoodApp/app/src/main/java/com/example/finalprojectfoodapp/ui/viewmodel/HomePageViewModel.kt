package com.example.finalprojectfoodapp.ui.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalprojectfoodapp.data.entity.Yemek
import com.example.finalprojectfoodapp.data.repo.YemeklerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import jakarta.inject.Inject
import kotlinx.coroutines.launch

@HiltViewModel
class HomePageViewModel @Inject constructor(
    private val repository: YemeklerRepository
) : ViewModel() {

    private val _yemekler = MutableLiveData<List<Yemek>>()
    val yemekler: LiveData<List<Yemek>> = _yemekler

    init {
        getYemekler()
    }

    private fun getYemekler() {
        viewModelScope.launch {
            try {
                _yemekler.value = repository.getTumYemekler()
            } catch (e: Exception) {
                Log.e("HomePageVM", "Veri çekilemedi", e)
            }
        }
    }
}
