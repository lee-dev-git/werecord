package a.alt.z.werecord.data.db

import androidx.room.TypeConverter
import org.threeten.bp.LocalDate

class Converters {

    @TypeConverter
    fun toGenre(value: String) = Genre.valueOf(value)

    @TypeConverter
    fun toValue(genre: Genre) = genre.name

    @TypeConverter
    fun toLocalDate(epochDay: Long) = LocalDate.ofEpochDay(epochDay)

    @TypeConverter
    fun toEpochDay(localDate: LocalDate) = localDate.toEpochDay()
}