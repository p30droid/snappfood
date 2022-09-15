package com.navin.snappfood.ui.search

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.navin.nearby.api.ApiClient
import com.navin.nearby.api.IService
import com.navin.snappfood.models.Food
import com.navin.snappfood.models.FoodModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class SearchViewModel(application: Application) : AndroidViewModel(application) {


    lateinit var foodList : MutableLiveData<FoodModel>

    fun searchFood(name : String ) :  MutableLiveData<FoodModel>{

        foodList = MutableLiveData<FoodModel>()

        loadFoods(name)

        return foodList

    }

    fun loadFoods(foodName : String) {


        val iService : IService = ApiClient.retrofit.create(IService::class.java)


        iService.searchFoods(foodName).enqueue(object : Callback<FoodModel> {
            override fun onResponse(call: Call<FoodModel>, response: Response<FoodModel>) {
                foodList.value = response.body()
            }

            override fun onFailure(call: Call<FoodModel>, t: Throwable) {
                foodList.value = null
            }

        })



    }



}