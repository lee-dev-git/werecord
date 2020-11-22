package a.alt.z.werecord.domain.usecase.movie

import a.alt.z.werecord.di.IODispatcher
import a.alt.z.werecord.domain.repository.MovieRepository
import a.alt.z.werecord.domain.usecase.FlowUseCase
import a.alt.z.werecord.model.Movie
import a.alt.z.werecord.util.debug
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetTrendingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IODispatcher coroutineDispatcher: CoroutineDispatcher
): FlowUseCase<Unit, List<Movie>>(coroutineDispatcher) {

    override fun execute(parameters: Unit): Flow<List<Movie>> {
        debug { "<GetPopularMoviesUseCase.execute>" }
        return movieRepository.trendingMovies()
                .also { debug { "</GetPopularMoviesUseCase.execute>" } }
    }
}