package com.meeweel.testmyapi.api


import com.meeweel.testmyapi.AnimeListResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers

interface AnimeApi {

    @GET("./test.php?q=post&id=1")
    @Headers("Content-type: application/json")
    fun getAnimeList(): Single<AnimeListResponse>

    @GET("./test.php?q=post&id=1")
    @Headers("Content-type: application/json")
    fun getAnime1(): Single<AnimeListResponse>

    @GET("./test.php?q=post&id=2")
    @Headers("Content-type: application/json")
    fun getAnime2(): Single<AnimeListResponse>
}