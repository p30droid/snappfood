package com.navin.snappfood.ui.main.home

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.gms.ads.AdListener
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.LoadAdError
import com.navin.snappfood.R
import com.navin.snappfood.databinding.FragmentHomeBinding
import com.navin.snappfood.models.CategoryModel
import com.navin.snappfood.models.FoodModel
import com.navin.snappfood.models.IView
import com.navin.snappfood.ui.main.adapter.CategoryAdapter
import com.navin.snappfood.ui.main.adapter.FoodAdapter
import okhttp3.ResponseBody


class HomeFragment : Fragment() , IView<Any> {


    lateinit var binding: FragmentHomeBinding

    var presenter  = HomePresenter(this)
     var foodsPresenter = FoodsPresenter(this)

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        binding = FragmentHomeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        presenter.loadCategories()
        foodsPresenter.getLatestFoods()

        val adRequest = AdRequest.Builder().build()
        binding.ads.loadAd(adRequest)

        binding.ads.adListener = object: AdListener() {
            override fun onAdClicked() {
                // Code to be executed when the user clicks on an ad.
                Log.e("onAdClicked","onAdClicked")
            }

            override fun onAdClosed() {
                // Code to be executed when the user is about to return
                // to the app after tapping on an ad.
                Log.e("onAdClosed","onAdClosed")
            }

            override fun onAdFailedToLoad(adError : LoadAdError) {
                // Code to be executed when an ad request fails.
                Log.e("adError","${adError} and ${adError.responseInfo}")
            }

            override fun onAdImpression() {
                // Code to be executed when an impression is recorded
                // for an ad.
                Log.e("onAdImpression","onAdImpression")
            }

            override fun onAdLoaded() {
                // Code to be executed when an ad finishes loading.
                Log.e("onAdLoaded","onAdLoaded")
            }

            override fun onAdOpened() {
                // Code to be executed when an ad opens an overlay that
                // covers the screen.
                Log.e("onAdOpened","onAdOpened")
            }
        }



    }

 /*   override fun onSuccess(responseMessage: CategoryModel) {
         Log.e("","")
        binding.recyclerCategories.adapter = CategoryAdapter(requireContext() ,responseMessage.categoryList)
        binding.recyclerCategories.layoutManager = LinearLayoutManager(requireContext() ,
            LinearLayoutManager.HORIZONTAL , false)
    }*/

    override fun onFailure(errorResponseMessage: String) {
        Log.e("","")
    }

    override fun onError(errorResponseMessage: String) {
        Log.e("","")
    }

    override fun onSuccess(responseMessage: Any) {

        when (responseMessage) {
            is CategoryModel ->{
                Log.e("","")

                binding.recyclerCategories.adapter = CategoryAdapter(requireContext() ,responseMessage.categoryList)
                binding.recyclerCategories.layoutManager = LinearLayoutManager(requireContext() ,
                    LinearLayoutManager.HORIZONTAL , false)

            }
            is FoodModel -> {
                Log.e("","")
                binding.recyclerNewFoods.adapter = FoodAdapter(requireContext() , responseMessage.foodList)
                binding.recyclerNewFoods.layoutManager = LinearLayoutManager(requireContext() ,
                    LinearLayoutManager.HORIZONTAL , false)
            }




        }

    }


}