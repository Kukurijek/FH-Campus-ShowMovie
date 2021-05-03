package com.example.mad03_fragments_and_navigation.database

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.mad03_fragments_and_navigation.models.Movie
import androidx.room.Query as Query

@Dao
interface MovieDao {

    @Insert
    fun create(movie: Movie): Long

    @Update
    fun update(movie: Movie)

    @Delete
    fun delete(movieId: Long)

    @Query("DELETE FROM movie_table")
    fun clearTable()

    @Query("SELECT * FROM movie_table ORDER BY id DESC LIMIT 1")
    fun getAll(): LiveData<List<Movie>>
}