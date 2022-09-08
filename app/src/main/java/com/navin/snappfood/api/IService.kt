package com.navin.nearby.api

import com.navin.snappfood.models.CategoryModel
import com.navin.snappfood.models.FoodModel
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface IService {

    @GET("v1/search")
    fun getPlaces(
        @Header("Api-Key") api: String,
        @Query("term") term: String,
        @Query("lat") latitude: Double,
        @Query("lng") longitude: Double
    ): Call<ResponseBody>

    @GET("api.php?cat_list")
    fun categoryList() : Call<CategoryModel>

    @GET("api.php?latest")
    fun foodsList() : Call<FoodModel>

}