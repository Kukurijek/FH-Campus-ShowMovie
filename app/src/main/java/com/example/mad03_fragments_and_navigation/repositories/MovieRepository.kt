package com.example.mad03_fragments_and_navigation.repositories

import com.example.mad03_fragments_and_navigation.database.MovieDao
import com.example.mad03_fragments_and_navigation.models.Movie
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MovieRepository(private val movieDao: MovieDao) {
    // TODO implement me


    suspend fun clearTable() {
            withContext(Dispatchers.IO) {
                movieDao.clearTable()
            }
    }


    suspend fun updateTable(movieToUpdate: Movie) {
        withContext(Dispatchers.IO) {
            movieDao.run {
                update(movie = movieToUpdate)
            }
        }
    }

    suspend fun insertTable(movieToCreate: Movie) {
        withContext(Dispatchers.IO) {
            movieDao.run {
                create(movie = movieToCreate)
            }
        }
    }


    companion object {
        // For Singleton instantiation
        @Volatile private var instance: MovieRepository? = null

        fun getInstance(dao: MovieDao) =
            instance ?: synchronized(this) {
                instance ?: MovieRepository(dao).also { instance = it }
            }
    }
}