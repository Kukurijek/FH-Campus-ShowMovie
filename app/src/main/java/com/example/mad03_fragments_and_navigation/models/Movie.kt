package com.example.mad03_fragments_and_navigation.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.example.mad03_fragments_and_navigation.R

@Entity(tableName = "movie_table")
data class Movie(

    @ColumnInfo(name = "movie_title")
    var title: String = "",

    @Ignore
    var description: String = ""
) {
    @PrimaryKey(autoGenerate = true)
    var id: Long? = 0L

    @Ignore
    var rating: Float = 0.0F
        set(value) {
            if(value in 0.0..5.0) field = value
            else throw IllegalArgumentException("Rating value must be between 0 and 5")
        }
    @ColumnInfo(name = "movie_note")
    var note: String = ""

    @Ignore
    var imageId: Int = R.drawable.no_preview_3

    @Ignore
    var actors: MutableList<String> = mutableListOf()

    @Ignore
    var creators: MutableList<String> = mutableListOf()

    @Ignore
    var genres: List<String>? = null
}