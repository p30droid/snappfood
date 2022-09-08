package com.navin.snappfood.ui.main.home

import android.util.Log
import com.navin.snappfood.api.ApiCaller
import com.navin.snappfood.models.CategoryModel
import com.navin.snappfood.models.FoodModel
import com.navin.snappfood.models.IMessageListener
import com.navin.snappfood.models.IView
import okhttp3.ResponseBody

class FoodsPresenter(var iView: IView<FoodModel>) : IMessageListener<FoodModel> {


    var apiCaller: ApiCaller = ApiCaller()

    fun getLatestFoods() {
        apiCaller.getLatestFoods(this)
    }

    override fun onSuccess(responseMessage: FoodModel) {
        Log.e("", "")
        iView.onSuccess(responseMessage)
    }

    override fun onFailure(errorResponseMessage: String) {
        Log.e("", "")
        iView.onFailure(errorResponseMessage)
    }


}