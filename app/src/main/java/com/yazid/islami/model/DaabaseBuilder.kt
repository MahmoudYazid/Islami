package com.yazid.islami.model

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.converter.gson.GsonConverterFactory

object HadeethApi {
    val BASE_URL = "https://hadeethenc.com/api/v1/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory( GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService : HadeethApiService by lazy {
        retrofit.create(HadeethApiService::class.java)
    }
}


object SurahApi {
    val BASE_URL = "https://api.alquran.cloud/v1/"
    private val retrofit = Retrofit.Builder()
        .addConverterFactory( GsonConverterFactory.create())
        .baseUrl(BASE_URL)
        .build()

    val retrofitService : surahApiService by lazy {
        retrofit.create(surahApiService::class.java)
    }
}
