package com.example.finalprojectfoodapp.data.repo

import com.example.finalprojectfoodapp.data.entity.Yemek
import com.example.finalprojectfoodapp.retrofit.YemeklerService
import jakarta.inject.Inject
import com.example.finalprojectfoodapp.data.entity.SepetYemek
import com.example.finalprojectfoodapp.retrofit.CrudResponse

class YemeklerRepository @Inject constructor(
    private val yemeklerService: YemeklerService
) {
    suspend fun getTumYemekler(): List<Yemek> {
        return yemeklerService.getTumYemekler().yemekler
    }

    suspend fun sepeteYemekEkle(
        yemekAdi: String,
        yemekResimAdi: String,
        yemekFiyat: Int,
        yemekAdet: Int,
        kullaniciAdi: String
    ): CrudResponse {
        return yemeklerService.sepeteYemekEkle(
            yemekAdi, yemekResimAdi, yemekFiyat, yemekAdet, kullaniciAdi
        )
    }

    suspend fun getSepettekiYemekler(kullaniciAdi: String): List<SepetYemek> {
        return yemeklerService.getSepettekiYemekler(kullaniciAdi).sepetYemekler
    }

    suspend fun sepettenYemekSil(sepetYemekId: Int, kullaniciAdi: String): CrudResponse {
        return yemeklerService.sepettenYemekSil(sepetYemekId, kullaniciAdi)
    }
}


