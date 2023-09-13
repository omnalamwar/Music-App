package com.example.musicapp

import retrofit2.Call
import retrofit2.http.GET

interface MyInterface {

    @GET("products")
    fun getMyData(): Call<MyData>
}