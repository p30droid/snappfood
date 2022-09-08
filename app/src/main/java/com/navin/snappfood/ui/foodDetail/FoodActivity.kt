package com.navin.snappfood.ui.foodDetail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import coil.load
import com.navin.snappfood.R
import com.navin.snappfood.databinding.ActivityFoodBinding
import com.navin.snappfood.models.Food

class FoodActivity : AppCompatActivity() {

    lateinit var bundle : Bundle
    lateinit var food : Food
    lateinit var binding : ActivityFoodBinding
    var count  : Int = 0;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFoodBinding.inflate(layoutInflater)
        setContentView(binding.root)

        bundle = intent.extras!!
        food = bundle.getParcelable<Food>("food")!!

        binding.imgFood.load(food.bookThumbnailB)
        binding.txtTitle.setText(food.bookTitle)
        binding.txtPrice.setText("${food.bookNumbers}")

        binding.txtCount.setText("${count}")

        binding.linPlus.setOnClickListener({
            binding.txtCount.setText("${count++}")
        })

        binding.linMinues.setOnClickListener({
            binding.txtCount.setText("${count--}")
        })


    }
}