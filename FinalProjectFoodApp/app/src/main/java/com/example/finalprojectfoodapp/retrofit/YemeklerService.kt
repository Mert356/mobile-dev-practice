package com.example.finalprojectfoodapp.retrofit

import com.example.finalprojectfoodapp.data.entity.SepetYemek
import com.example.finalprojectfoodapp.data.entity.Yemek
import com.google.gson.annotations.SerializedName
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface YemeklerService {

    @GET("yemekler/tumYemekleriGetir.php")
    suspend fun getTumYemekler(): YemeklerResponse

    @FormUrlEncoded
    @POST("yemekler/sepeteYemekEkle.php")
    suspend fun sepeteYemekEkle(
        @Field("yemek_adi") yemekAdi: String,
        @Field("yemek_resim_adi") yemekResimAdi: String,
        @Field("yemek_fiyat") yemekFiyat: Int,
        @Field("yemek_siparis_adet") yemekAdet: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    ): CrudResponse

    @FormUrlEncoded
    @POST("yemekler/sepettekiYemekleriGetir.php")
    suspend fun getSepettekiYemekler(
        @Field("kullanici_adi") kullaniciAdi: String
    ): SepetResponse

    @FormUrlEncoded
    @POST("yemekler/sepettenYemekSil.php")
    suspend fun sepettenYemekSil(
        @Field("sepet_yemek_id") sepetYemekId: Int,
        @Field("kullanici_adi") kullaniciAdi: String
    ): CrudResponse
}


data class YemeklerResponse(
    @SerializedName("yemekler") val yemekler: List<Yemek>
)
data class CrudResponse(
    @SerializedName("success") val success: Int,
    @SerializedName("message") val message: String
)
data class SepetResponse(
    @SerializedName("sepet_yemekler") val sepetYemekler: List<SepetYemek>
)
