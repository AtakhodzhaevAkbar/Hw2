package com.example.m5_hw2


import com.example.m5_hw2.data.Models.LoveModel
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query
import retrofit2.Call

interface LoveApiService {
    //https://love-zcalculator.p.rapidapi.com/getPercentage?sname=John&fname=Alice
    @GET("getPercentage")
    fun getPercentage(
        @Header("X-RapidAPI-Key")apiKey: String = "692f5dad7bmsh2a8d0b085da86c5p12033fjsnc22c9adc4708",
        @Header("X-RapidAPI-Host")apiHost: String = "love-calculator.p.rapidapi.com",
        @Query("fname")firstName: String,
        @Query("sname")secondName: String,
    ):Call<LoveModel>
}