package a.alt.z.werecord.data.source

import a.alt.z.werecord.data.db.MovieDao
import a.alt.z.werecord.data.db.MovieEntity
import a.alt.z.werecord.data.model.TmdbMovie
import a.alt.z.werecord.data.model.posterUrl
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

interface MovieLocalDataSource {

    fun trendingMovies(): Flow<List<MovieEntity>>

    suspend fun addTrendingMovies(movies: List<TmdbMovie>)
}

@Singleton
class DBMovieDataSource @Inject constructor(
    private val movieDao: MovieDao
): MovieLocalDataSource {

    override fun trendingMovies(): Flow<List<MovieEntity>> = movieDao.movies()

    override suspend fun addTrendingMovies(movies: List<TmdbMovie>) {
        movies.takeIf { it.isNotEmpty() }
            ?.map { it.toMovieEntity() }
            ?.let {
                movieDao.clear()
                movieDao.insert(it)
            }
    }
}

fun TmdbMovie.toMovieEntity(): MovieEntity
        = MovieEntity(id = id, posterUrl = posterUrl ?: backdropPath, title = title, overview = overview, popularity = popularity)