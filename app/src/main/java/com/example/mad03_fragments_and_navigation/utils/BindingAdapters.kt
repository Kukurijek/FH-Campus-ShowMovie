package com.example.mad03_fragments_and_navigation.utils

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("mapListToString")
fun bindMapListToString(view: TextView, list: MutableList<String>?) {
    when(list){
        null -> view.text = ""
        else -> {
            var textString = ""

            for((idx, el) in list.withIndex()){
                if(idx != 0){
                    textString += ", "
                }
                textString += el
            }

            view.text = textString
        }
    }
}

@BindingAdapter("setImageSrc")
fun setImageResource(imageView: ImageView, resource: Int) {
    imageView.setImageResource(resource)
}