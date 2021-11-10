package com.meeweel.testmyapi

import com.google.gson.annotations.SerializedName

data class AnimeListItem(val items: List<AnimeListItem>)

data class AnimeListResponse(
    @SerializedName("originalTitle")
    val title: String,
    // Если переменная не совпадает с названием в гсон файле, тогда
    // необходима аннотация с указанием названия переменной в гсоне
    //
    @SerializedName("ruDescription")
    val description: String,
    @SerializedName("image")
    val image: String
)