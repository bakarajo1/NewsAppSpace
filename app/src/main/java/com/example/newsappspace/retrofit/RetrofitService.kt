package com.example.newsappspace.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


const val ApiKey="6ffa91c0504d4f74acd8065f23646152"

object RetrofitService {
    private const val Url= "https://newsapi.org/"

    val retrofit:Retrofit by lazy {
        Retrofit.Builder().baseUrl(Url).addConverterFactory(GsonConverterFactory.create()).build()
    }
    val apiService:ApiService by lazy{
        retrofit.create(ApiService::class.java)
    }
}