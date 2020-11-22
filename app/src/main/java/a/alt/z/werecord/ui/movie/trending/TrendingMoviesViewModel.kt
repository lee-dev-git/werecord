package a.alt.z.werecord.ui.movie.trending

import a.alt.z.werecord.domain.usecase.movie.GetTrendingMoviesUseCase
import a.alt.z.werecord.domain.usecase.toResult
import a.alt.z.werecord.util.debug
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData

class TrendingMoviesViewModel @ViewModelInject constructor(
    getTrendingMoviesUseCase: GetTrendingMoviesUseCase
): ViewModel() {

    init {
        debug { "PopularMoviesViewModel.init" }
    }

    val popularMovies = getTrendingMoviesUseCase(Unit)
        .toResult()
        .asLiveData()

    fun refresh() {

    }
}