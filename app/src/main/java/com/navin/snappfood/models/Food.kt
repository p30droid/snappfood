package com.navin.snappfood.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize


@Parcelize
data class Food(
    var id : Int,
    @SerializedName("cat_id")
    var catId : Int,
    @SerializedName("book_title")
    var bookTitle : String,
    @SerializedName("book_url")
    var bookUrl : String,
    @SerializedName("book_thumbnail_b")
    var bookThumbnailB : String,
    @SerializedName("book_thumbnail_s")
    var bookThumbnailS : String,
    @SerializedName("book_numbers")
    var bookNumbers : String,
    @SerializedName("book_publisher")
    var bookPublisher : String,
    @SerializedName("book_description")
    var bookDescription : String,
    @SerializedName("total_rate")
    var totalRate : Int,
    @SerializedName("rate_avg")
    var rateAvg : Int,
    @SerializedName("total_views")
    var totalViews : Int,
    @SerializedName("category_name")
    var categoryName : String,
    @SerializedName("category_image")
    var categoryImage : String,
    @SerializedName("category_image_thumb")
    var categoryImageThumb : String,

) : Parcelable
