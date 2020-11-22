package a.alt.z.werecord.model

data class Movie(
    val id: Long,
    val posterUrl: String?,
    val title: String,
    val overview: String,
    val popularity: Double
)