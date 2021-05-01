package com.example.mad03_fragments_and_navigation

import android.os.Bundle
import android.view.*
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.example.mad03_fragments_and_navigation.adapters.MovieListAdapter
import com.example.mad03_fragments_and_navigation.databinding.FragmentHomeBinding
import com.example.mad03_fragments_and_navigation.models.MovieStore


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        setHasOptionsMenu(true) // enable the options menu in the action bar

        val adapter = MovieListAdapter()    // instantiate a new MovieListAdapter for recyclerView
        binding.movieList.adapter = adapter // assign adapter to the recyclerView

        subscribeUI(adapter)

        return binding.root
    }

    private fun subscribeUI(adapter: MovieListAdapter){
        val movieList = MovieStore()
        adapter.submitList(movieList.defaultMovies) // submit the statically generated movielist to the recyclerView
    }

    /**
     * Navigation behavior if options menu item is clicked
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return NavigationUI.
        onNavDestinationSelected(item, requireView().findNavController())
                || super.onOptionsItemSelected(item)
    }

    /**
     * inflate the options menu
     */
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.options_menu, menu)
    }
}