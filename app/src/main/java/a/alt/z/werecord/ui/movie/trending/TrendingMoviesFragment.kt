package a.alt.z.werecord.ui.movie.trending

import a.alt.z.werecord.R
import a.alt.z.werecord.databinding.FragmentPopularMoviesBinding
import a.alt.z.werecord.domain.usecase.data
import a.alt.z.werecord.util.viewBinding
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class TrendingMoviesFragment: Fragment(R.layout.fragment_popular_movies) {

    private val binding by viewBinding(FragmentPopularMoviesBinding::bind)

    private val adapter = TrendingMoviesAdapter()

    private val viewModel: TrendingMoviesViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        setupObserver()
    }

    private fun init() {
        binding.apply {
            trendingMoviesRecyclerView.adapter = adapter
            trendingMoviesRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        }
    }

    private fun setupObserver() {
        viewModel.popularMovies.observe(viewLifecycleOwner) { result ->
            result
                .data
                ?.let { popularMovies -> adapter.submitList(popularMovies) }
        }
    }
}