package com.example.kagoben_mobile.model.service

import com.example.kagoben_mobile.model.Keranjang
import com.example.kagoben_mobile.model.KeranjangReq
import com.example.kagoben_mobile.model.KeranjangRespons
import com.example.kagoben_mobile.model.MemberLoginResponse
import com.example.kagoben_mobile.model.MemberRegisterResponse
import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.Date


private const val BASE_URL = "http://52.7.48.144:3001/api/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(GsonConverterFactory.create(Gson()))
    .baseUrl(BASE_URL)
    .build()


interface AuthApiService {
    @FormUrlEncoded
    @POST("login")
    suspend fun login(
        @Field("email") email: String,
        @Field("password") password: String
    ):MemberLoginResponse
    @FormUrlEncoded
    @POST("register")
    suspend fun register(
        @Field("email") email: String,
        @Field("username") username: String,
        @Field("usia") usia: String,
        @Field("no_telepon") noTelepon: String,
        @Field("password") password: String
    ): MemberRegisterResponse
}
interface KeranjangApiService{
    @GET("keranjang")
    suspend fun getAllKeranjang(@Header("Authorization") token: String): KeranjangRespons
    @POST("keranjang/create")
    suspend fun createKeranjang(
        @Header("Authorization") token: String,
        @Body reqData: KeranjangReq
    )
}

object ApiService {
    val retrofitService: AuthApiService by lazy {
        retrofit.create(AuthApiService::class.java)
    }
    val keranjangService: KeranjangApiService by lazy {
        retrofit.create(KeranjangApiService::class.java)
    }
}