package a.alt.z.werecord.data.db

import androidx.room.*
import kotlinx.coroutines.flow.Flow

@Dao
interface PerformanceDao {

    @Query("SELECT * FROM performance")
    fun performances(): Flow<List<PerformanceEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(performance: PerformanceEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(performances: List<PerformanceEntity>)

    @Update
    suspend fun update(performance: PerformanceEntity)

    @Delete
    suspend fun delete(performance: PerformanceEntity)

    @Query("DELETE FROM performance WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM performance")
    suspend fun clear()
}