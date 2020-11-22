package a.alt.z.werecord.data.api

import a.alt.z.werecord.data.model.TmdbMovie
import a.alt.z.werecord.data.model.TmdbResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbService {

    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("language") language: String = "ko-KR"): TmdbResponse<TmdbMovie>

    @GET("/search/movie")
    suspend fun searchMovie(@Query("query") query: String): TmdbResponse<TmdbMovie>
}