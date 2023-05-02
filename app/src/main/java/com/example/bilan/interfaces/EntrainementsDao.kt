package com.example.bilan.interfaces


import androidx.room.*
import com.example.bilan.models.Entrainements
import com.example.bilan.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface EntrainementsDao {

    @Query("SELECT * FROM Entrainements WHERE userId=:id AND strftime('%W', date) = strftime('%W', 'now')")
    fun getAllEntrainementsWeek(id:Int): Flow<List<Entrainements>>

    @Query("SELECT * FROM Entrainements WHERE userId=:id AND strftime('%w', date) = :dayOfWeek")
    suspend fun getEntrainementsByDate(id: Int, dayOfWeek: String): Entrainements?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertEntrainements(entrainements: Entrainements)

    @Update
    suspend fun updateEntrainements(entrainements: Entrainements)

    @Delete
    suspend fun deleteEntrainements(entrainements: Entrainements)
}
