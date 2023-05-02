package com.example.bilan.repositories


import com.example.bilan.interfaces.UserDao
import com.example.bilan.models.User
import kotlinx.coroutines.Dispatchers

class UserRepository(private val userDao: UserDao) {
    val users = userDao.getAllUsers()

     suspend fun insertUser(todo: User) {
        Dispatchers.IO.apply {
            userDao.insertUser(todo)
        }
    }

    suspend fun deleteUser(todo: User) {
        Dispatchers.IO.apply {
            userDao.deleteUser(todo)
        }
    }

    suspend fun updateUser(todo:User) {
        Dispatchers.IO.apply {
            userDao.updateUser(todo)
        }
    }

    suspend fun getUserById(id:Int):User? {
        Dispatchers.IO.apply {
            return userDao.getUserById(id)
        }
    }


}