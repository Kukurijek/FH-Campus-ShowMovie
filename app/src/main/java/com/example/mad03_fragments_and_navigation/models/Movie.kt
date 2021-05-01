package com.example.mad03_fragments_and_navigation.models

import com.example.mad03_fragments_and_navigation.R

data class Movie(
    var title: String = "",
    var description: String = ""
) {
    var id: Long? = 0L
    var rating: Float = 0.0F
        set(value) {
            if(value in 0.0..5.0) field = value
            else throw IllegalArgumentException("Rating value must be between 0 and 5")
        }
    var note: String = ""
    var imageId: Int = R.drawable.no_preview_3
    var actors: MutableList<String> = mutableListOf()
    var creators: MutableList<String> = mutableListOf()
    var genres: List<String>? = null
}
