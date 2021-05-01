package com.example.mad03_fragments_and_navigation.repositories

import com.example.mad03_fragments_and_navigation.database.MovieDao

class MovieRepository(private val movieDao: MovieDao) {
    // TODO implement me

    companion object {
        // For Singleton instantiation
        @Volatile private var instance: MovieRepository? = null

        fun getInstance(dao: MovieDao) =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(dao).also { instance = it }
            }
    }
}