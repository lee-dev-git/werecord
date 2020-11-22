package a.alt.z.werecord.data.model

import com.google.gson.annotations.SerializedName

data class TmdbMovie(
    @SerializedName("poster_path")
    val posterPath: String?,
    val adult: Boolean,
    val overview: String,
    @SerializedName("release_date")
    val releaseDate: String?,
    @SerializedName("genre_ids")
    val genreIds: List<Long>?,
    val id: Long,
    @SerializedName("original_title")
    val originalTitle: String,
    @SerializedName("original_language")
    val originalLanguage: String,
    val title: String,
    @SerializedName("backdrop_path")
    val backdropPath: String?,
    val popularity: Double,
    @SerializedName("vote_count")
    val voteCount: Int,
    val video: Boolean,
    @SerializedName("vote_average")
    val voteAverage: Double?
)

val TmdbMovie.posterUrl: String?
    get() = posterPath?.let { "https://image.tmdb.org/t/p/original$it" }

val TmdbMovie.backdropUrl: String?
    get() = backdropPath?.let { "https://image.tmdb.org/t/p/original$it" }