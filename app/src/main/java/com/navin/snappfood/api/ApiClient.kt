package com.navin.nearby.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClient {

    val retrofit = Retrofit.Builder()
        .baseUrl("http://flutterapps.ir/apps/snappfood/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()



}