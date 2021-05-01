package com.example.mad03_fragments_and_navigation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mad03_fragments_and_navigation.repositories.MovieRepository

@Suppress("UNCHECKED_CAST")
class MovieFavoritesViewModelFactory(
    private val repository: MovieRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MovieFavoritesViewModel::class.java)) {
            return MovieFavoritesViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}