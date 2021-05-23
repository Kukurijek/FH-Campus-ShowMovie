package com.example.mad03_fragments_and_navigation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mad03_fragments_and_navigation.models.Movie
import com.example.mad03_fragments_and_navigation.repositories.MovieRepository
import kotlinx.coroutines.launch

class MovieFavoritesViewModel (
    private val repository: MovieRepository
): ViewModel() {

    fun clearTable() {
        viewModelScope.launch {
            repository.clearTable()
        }
    }

    fun deleteMovie(id: Long) {
        viewModelScope.launch {
            repository.delete(movieId = id)
        }
    }

    fun gettAll() {
        viewModelScope.launch {
            repository.getAll()
        }
    }

    fun insertMovie(movie: Movie) {
        viewModelScope.launch {
            repository.insertTable(movieToCreate = movie)
        }
    }

    fun updateMovie(movie: Movie) {
        viewModelScope.launch {
            repository.updateTable(movieToUpdate = movie)
        }
    }
}