package com.navin.snappfood.models

import com.google.gson.annotations.SerializedName

data class FoodModel(
    @SerializedName("ONLINE_Book")
    val foodList: List<Food>
)