package com.example.mad03_fragments_and_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mad03_fragments_and_navigation.adapters.FavoritesListAdapter
import com.example.mad03_fragments_and_navigation.databinding.FragmentFavoritesBinding
import com.example.mad03_fragments_and_navigation.models.Movie


class FavoritesFragment : Fragment() {
    private lateinit var binding: FragmentFavoritesBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_favorites, container, false)

        val adapter = FavoritesListAdapter(
            dataSet = listOf(),     // start with empty list
            onDeleteClicked = {movieId -> onDeleteMovieClicked(movieId)},   // pass functions to adapter
            onEditClicked = {movie -> onEditMovieClicked(movie)},           // pass functions to adapter
        )

        with(binding){
            recyclerView.adapter = adapter
        }

        return binding.root
    }

    // This is called when recyclerview item edit button is clicked
    private fun onEditMovieClicked(movieObj: Movie){
        // TODO implement me
    }

    // This is called when recyclerview item remove button is clicked
    private fun onDeleteMovieClicked(movieId: Long){
        // TODO implement me
    }
}