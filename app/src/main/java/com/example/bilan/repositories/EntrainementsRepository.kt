package com.example.bilan.repositories


import com.example.bilan.interfaces.EntrainementsDao
import com.example.bilan.models.Entrainements
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow

class EntrainementsRepository(private val entrainementsDao: EntrainementsDao) {


    suspend fun insertEntrainements(todo: Entrainements) {
        Dispatchers.IO.apply {
            entrainementsDao.insertEntrainements(todo)
        }
    }

    suspend fun deleteEntrainements(todo: Entrainements) {
        Dispatchers.IO.apply {
            entrainementsDao.deleteEntrainements(todo)
        }
    }

    suspend fun updateEntrainements(todo:Entrainements) {
        Dispatchers.IO.apply {
            entrainementsDao.updateEntrainements(todo)
        }
    }

    suspend fun getAllEntrainementsWeek(id:Int): List<Entrainements> {
        Dispatchers.IO.apply {
            return entrainementsDao.getAllEntrainementsWeek(id)
        }
    }

    suspend fun getEntrainementsByDate(id: Int, dayOfWeek: String): Entrainements{
        Dispatchers.IO.apply {
            return entrainementsDao.getEntrainementsByDate(id, dayOfWeek)
        }
    }

}