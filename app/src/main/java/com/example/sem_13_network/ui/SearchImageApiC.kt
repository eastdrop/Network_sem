package com.example.sem_13_network.ui

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://api.thecatapi.com/"

object RetrofitServices {
    val moshi = Moshi.Builder()
        .addLast(KotlinJsonAdapterFactory())
        .build()
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create(moshi))
        .build()

    val searchImageApiC: SearchImageApiC = retrofit.create(SearchImageApiC::class.java)
}

interface SearchImageApiC {
    /*@Headers(
        "Accept: application/json",
        "Content-type: application/json"
    )*/
    /*@GET("/v1/{images}/search?limit=1")
    fun getCatImage(@Path("images") images: String = "images"): Call<List<CatImageModel>>*/
    @GET("/v1/images/search")
    suspend fun getCatImageList(): Response<List<CatImageModel>>
}