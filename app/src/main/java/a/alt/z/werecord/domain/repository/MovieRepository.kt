package a.alt.z.werecord.domain.repository

import a.alt.z.werecord.model.Movie
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun searchMovie(query: String): List<Movie>

    fun trendingMovies(): Flow<List<Movie>>

    suspend fun reloadTrendingMovies()
}