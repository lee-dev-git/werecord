package a.alt.z.werecord.domain.usecase.movie

import a.alt.z.werecord.di.IODispatcher
import a.alt.z.werecord.domain.repository.MovieRepository
import a.alt.z.werecord.domain.usecase.UseCase
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

class ReloadTrendingMoviesUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IODispatcher coroutineDispatcher: CoroutineDispatcher
): UseCase<Unit, Unit>(coroutineDispatcher) {

    override suspend fun execute(parameters: Unit) = movieRepository.reloadTrendingMovies()
}