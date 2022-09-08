package com.navin.snappfood.models

import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("category_image")
    val categoryImage: String,
    @SerializedName("category_image_thumb")
    val categoryImageThumb: String,
    @SerializedName("category_name")
    val categoryName: String,
    @SerializedName("cid")
    val cid: String
)