package com.example.mad03_fragments_and_navigation.database

import androidx.lifecycle.LiveData
import com.example.mad03_fragments_and_navigation.models.Movie

interface MovieDao {

    fun create(movie: Movie): Long

    fun update(movie: Movie)

    fun delete(movieId: Long)

    fun clearTable()

    fun getAll(): LiveData<List<Movie>>
}