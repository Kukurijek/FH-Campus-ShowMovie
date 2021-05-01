package com.example.mad03_fragments_and_navigation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.mad03_fragments_and_navigation.models.Movie
import androidx.recyclerview.widget.RecyclerView
import com.example.mad03_fragments_and_navigation.HomeFragmentDirections
import com.example.mad03_fragments_and_navigation.R
import com.example.mad03_fragments_and_navigation.databinding.MovieItemBinding


class MovieListAdapter:
    ListAdapter<Movie, RecyclerView.ViewHolder>(
        MovieDiffCallback()
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder{
        return ViewHolder(
            DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.movie_item, parent, false),   //the binding
        )
    }

    /**
     * Called by RecyclerView to display the data at the specified position. This method should
     * update the contents of the [ViewHolder] to reflect the item at the given
     * position.
     * */
    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //call the custom bind function from ViewHolder class
        if(holder is ViewHolder){
            holder.bind(getItem(position))
        }
    }

    class ViewHolder(
        private val binding: MovieItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.goToDetailBtn.setOnClickListener{ btnView ->
                binding.movie?.id?.let { itemId->
                    btnView.findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMovieDetailFragment(itemId.toString()))
                }
            }
        }

        fun bind(movieItem: Movie) {
            with(binding) {
                movie = movieItem
                /**
                 * Evaluates the pending bindings, updating any Views that have expressions bound to
                 * modified variables.
                 */
                executePendingBindings()
            }
        }
    }
}

    private class MovieDiffCallback : DiffUtil.ItemCallback<Movie>() {
        override fun areItemsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem.title == newItem.title
        }

        override fun areContentsTheSame(
            oldItem: Movie,
            newItem: Movie
        ): Boolean {
            return oldItem == newItem
        }
    }