package com.navin.snappfood.ui.main.home

import android.util.Log
import com.navin.snappfood.api.ApiCaller
import com.navin.snappfood.models.CategoryModel
import com.navin.snappfood.models.IMessageListener
import com.navin.snappfood.models.IView
import okhttp3.ResponseBody

class HomePresenter(var iView: IView<CategoryModel>) : IMessageListener<CategoryModel> {

    var apiCaller: ApiCaller = ApiCaller()

    /*  var iview : IView<ResponseBody>
      constructor(iview : IView<ResponseBody>) {
          this.iview = iview
      }*/


    fun loadCategories() {
        apiCaller.getCategories(this)
    }

    override fun onSuccess(responseMessage: CategoryModel) {
        Log.e("", "")
        iView.onSuccess(responseMessage)
    }

    override fun onFailure(errorResponseMessage: String) {
        Log.e("", "")
        iView.onFailure(errorResponseMessage)
    }


}