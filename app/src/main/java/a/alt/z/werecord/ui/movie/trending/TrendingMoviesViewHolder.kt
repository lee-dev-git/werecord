package a.alt.z.werecord.ui.movie.trending

import a.alt.z.werecord.databinding.ItemTrendingMovieBinding
import a.alt.z.werecord.model.Movie
import android.util.TypedValue
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation

class TrendingMoviesViewHolder(
        private val binding: ItemTrendingMovieBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(movie: Movie) = binding.run {
        trendingMovieItemImageView.load(movie.posterUrl) {
            val radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4F, root.context.resources.displayMetrics)
            transformations(RoundedCornersTransformation(radius))
        }
        trendingMovieItemTitleTextView.text = movie.title
        /* TODO */ trendingMovieItemGenreTextView.text = genres.random()
    }

    private val genres = listOf("액션", "SF", "코미디", "스릴러", "판타지", "멜로")
}