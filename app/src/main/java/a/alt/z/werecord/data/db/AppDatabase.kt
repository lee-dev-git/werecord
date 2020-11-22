package a.alt.z.werecord.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(
    entities = [MovieEntity::class, PerformanceEntity::class],
    version = 2 /* TODO(version = 1) */
)
@TypeConverters(value = [Converters::class])
abstract class AppDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieDao

    abstract fun performanceDao(): PerformanceDao

    companion object {
        private const val databaseName = "aaltz"

        fun buildDatabase(context: Context): AppDatabase {
            return Room
                .databaseBuilder(context, AppDatabase::class.java, databaseName)
                .fallbackToDestructiveMigration()
                .build()
        }
    }
}