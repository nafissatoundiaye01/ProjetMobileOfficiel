package com.example.bilan.interfaces


import androidx.room.*
import com.example.bilan.models.Entrainements
import com.example.bilan.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface EntrainementsDao {
    @Query("SELECT * FROM Entrainements Where id=:id")
    fun getAllEntrainementsWeek(id:Int): Flow<List<Entrainements>>

    @Query("SELECT * FROM User WHERE id=:id")
    suspend fun getUserById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}
