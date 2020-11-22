package a.alt.z.werecord.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface MovieDao {

    @Query("SELECT * FROM movie")
    fun movies(): Flow<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movie: MovieEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(movies: List<MovieEntity>)

    @Update
    suspend fun update(performance: PerformanceEntity)

    @Delete
    suspend fun delete(performance: PerformanceEntity)

    @Query("DELETE FROM performance WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM movie")
    suspend fun clear()
}