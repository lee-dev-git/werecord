package a.alt.z.werecord.domain.usecase.movie

import a.alt.z.werecord.di.IODispatcher
import a.alt.z.werecord.domain.repository.MovieRepository
import a.alt.z.werecord.domain.usecase.UseCase
import a.alt.z.werecord.model.Movie
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SearchMovieUseCase @Inject constructor(
    private val movieRepository: MovieRepository,
    @IODispatcher coroutineDispatcher: CoroutineDispatcher
): UseCase<String, List<Movie>>(coroutineDispatcher) {

    override suspend fun execute(parameters: String): List<Movie> = movieRepository.searchMovie(query = parameters)
}
