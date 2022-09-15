package com.navin.snappfood.ui.search

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.navin.snappfood.R
import com.navin.snappfood.databinding.ActivitySearchBinding
import com.navin.snappfood.models.FoodModel
import com.navin.snappfood.ui.main.adapter.FoodAdapter

class SearchActivity : AppCompatActivity() {

    lateinit var binding : ActivitySearchBinding

    var bundle : Bundle?=null

    lateinit var viewModel: SearchViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySearchBinding.inflate(layoutInflater)
        setContentView(binding.root)


        bundle = intent.extras

        val search : String = bundle!!.getString("data")!!

        Log.e("search","${search}")

        viewModel = ViewModelProvider(this).get(SearchViewModel::class.java)


        viewModel.searchFood(search).observe(this, object : Observer<FoodModel> {
            override fun onChanged(t: FoodModel?) {

                Log.e("","")

                if(t!=null) {

                    binding.recyclerFoods.adapter = FoodAdapter(applicationContext , t.foodList)
                    binding.recyclerFoods.layoutManager = LinearLayoutManager(applicationContext ,
                        LinearLayoutManager.HORIZONTAL , false)

                }


            }

        })


    }
}