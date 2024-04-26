package com.example.m5_hw2


import com.example.m5_hw2.Models.CharactersResponce
import retrofit2.http.GET
import retrofit2.Call
import retrofit2.http.Query

interface RickAndMortyApiService {
    //https://love-zcalculator.p.rapidapi.com/getPercentage?sname=John&fname=Alice
    @GET("character")
    fun getCharacters(
        @Query("page") page: Int
    ):Call<CharactersResponce>
}