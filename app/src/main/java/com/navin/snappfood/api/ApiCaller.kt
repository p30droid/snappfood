package com.navin.snappfood.api

import android.util.Log
import com.navin.nearby.api.ApiClient
import com.navin.nearby.api.IService
import com.navin.snappfood.models.CategoryModel
import com.navin.snappfood.models.FoodModel
import com.navin.snappfood.models.IMessageListener
 import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ApiCaller {

    val iService : IService = ApiClient.retrofit.create(IService::class.java)


    fun getCategories(listener : IMessageListener<CategoryModel>) {

        Log.e("","")
        iService.categoryList().enqueue(object  : Callback<CategoryModel> {
            override fun onResponse(call: Call<CategoryModel>, response: Response<CategoryModel>) {
                 Log.e("","")
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<CategoryModel>, t: Throwable) {
                Log.e("","")
                listener.onFailure("")
            }

        })


    }



    fun getLatestFoods(listener : IMessageListener<FoodModel>) {

        Log.e("","")
        iService.foodsList().enqueue(object  : Callback<FoodModel> {
            override fun onResponse(call: Call<FoodModel>, response: Response<FoodModel>) {
                Log.e("","")
                response.body()?.let { listener.onSuccess(it) }
            }

            override fun onFailure(call: Call<FoodModel>, t: Throwable) {
                Log.e("","")
                listener.onFailure("")
            }

        })


    }

}