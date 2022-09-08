package com.navin.snappfood.models

import com.google.gson.annotations.SerializedName

data class CategoryModel(
    @SerializedName("ONLINE_Book")
    val categoryList: List<Category>
)