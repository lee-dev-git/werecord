package a.alt.z.werecord.ui.movie.trending

import a.alt.z.werecord.databinding.ItemTrendingMovieBinding
import a.alt.z.werecord.model.Movie
import a.alt.z.werecord.util.layoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class TrendingMoviesAdapter: ListAdapter<Movie, TrendingMoviesViewHolder>(callback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TrendingMoviesViewHolder {
        return ItemTrendingMovieBinding
                .inflate(parent.layoutInflater, parent, false)
                .let { TrendingMoviesViewHolder(it) }
    }

    override fun onBindViewHolder(holder: TrendingMoviesViewHolder, position: Int) = holder.bind(getItem(position))

    companion object {
        private val callback = object: DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem == newItem
            override fun areContentsTheSame(oldItem: Movie, newItem: Movie): Boolean = oldItem.id == newItem.id
        }
    }
}