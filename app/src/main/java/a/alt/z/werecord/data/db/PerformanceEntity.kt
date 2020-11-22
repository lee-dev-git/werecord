package a.alt.z.werecord.data.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import org.threeten.bp.LocalDate

/**
 * 공연
 */
@Entity(tableName = "performance")
data class PerformanceEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    @ColumnInfo(name = "kopis_id")
    val kopisId: String,
    val name: String,
    val date: LocalDate,
    val place: String,
    @ColumnInfo(name = "poster_url")
    val posterUrl: String,
    val genre: Genre,
    @ColumnInfo(name = "start_date")
    val startDate: LocalDate,
    @ColumnInfo(name = "end_date")
    val endDate: LocalDate
)

/**
 * 연극, 뮤지컬, 클래식, 오페라, 무용, 국악, 복합
 */
enum class Genre {
    PLAY, MUSICAL, CLASSICAL_MUSIC, OPERA, DANCE, TRADITIONAL_MUSIC, COMPLEX
}