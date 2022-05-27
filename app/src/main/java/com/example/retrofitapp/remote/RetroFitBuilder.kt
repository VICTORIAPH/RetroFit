package com.example.retrofitapp.remote

import android.telecom.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RetroFitBuilder {
    @GET("pokemon/{id}")
    fun getPokemonById(@Path("id") id:String): retrofit2.Call<PokemonEntry>

    companion object{
       private val BASE_URL = "https://pokeapi.co/api/v2/"

        fun create(): RetroFitBuilder{
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
                    return retrofit.create(RetroFitBuilder::class.java)
        }
    }
}