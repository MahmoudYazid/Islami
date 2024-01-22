package com.yazid.islami.model

import retrofit2.http.GET
import retrofit2.http.Query

interface HadeethApiService {
    @GET("hadeeths/one/?language=ar")
    suspend fun getHadeth(@Query("id") id: String):Response
}

interface surahApiService {
    @GET("surah")
    suspend fun getAllSurah():SurahResponse
}