package a.alt.z.werecord.ui.movie.search

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import a.alt.z.werecord.R
import androidx.fragment.app.viewModels
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchMovieFragment : Fragment(R.layout.fragment_search_movie) {

    private val viewModel: SearchMovieViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        init()

        setupObserver()
    }

    private fun init() {

    }

    private fun setupObserver() {

    }
}