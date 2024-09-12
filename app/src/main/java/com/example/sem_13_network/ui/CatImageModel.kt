package com.example.sem_13_network.ui

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CatImageModel(
    // Realization using Gson lib
    /*@SerializedName("id") val id: String,
    @SerializedName("url") val url: String*/
    //moshi lib
    @Json(name = "id") val id: String,
    @Json(name = "url") val url: String
)