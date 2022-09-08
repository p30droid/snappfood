package com.navin.snappfood.ui.main.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.AppCompatImageView
import androidx.appcompat.widget.AppCompatTextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.navin.snappfood.R
import com.navin.snappfood.models.Category

class CategoryAdapter(mContext : Context , list : List<Category>) : RecyclerView.Adapter<CategoryAdapter.CatgeoryVH>() {

    val context = mContext
    val categoryList = list

    class CatgeoryVH(itemView: View) : RecyclerView.ViewHolder(itemView) {

        val imgCategory = itemView.findViewById<AppCompatImageView>(R.id.img_category)
        val txtTitle = itemView.findViewById<AppCompatTextView>(R.id.txt_title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CatgeoryVH {

        val view: View = LayoutInflater.from(context).inflate(R.layout.category_row , null)
        return  CatgeoryVH(view)

    }

    override fun onBindViewHolder(holder: CatgeoryVH, position: Int) {


        var category = categoryList.get(position)

        holder.imgCategory.load(category.categoryImage)
        holder.txtTitle.setText(category.categoryName)

                //imageView.load("https://www.example.com/image.jpg") {
        //    crossfade(true)
        //    placeholder(R.drawable.image)
        //    transformations(CircleCropTransformation())
        //}


     }

    override fun getItemCount(): Int {
        return  categoryList.size
     }
}