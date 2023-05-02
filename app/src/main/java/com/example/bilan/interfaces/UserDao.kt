package com.example.bilan.interfaces


import androidx.room.*
import com.example.bilan.models.User
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Query("SELECT * FROM User")
     fun getAllUsers(): Flow<List<User>>

    @Query("SELECT * FROM User WHERE id=:id")
    suspend fun getUserById(id: Int): User?

    @Insert(onConflict = OnConflictStrategy.REPLACE)
     suspend fun insertUser(user: User)

    @Update
    suspend fun updateUser(user: User)

    @Delete
    suspend fun deleteUser(user: User)
}
