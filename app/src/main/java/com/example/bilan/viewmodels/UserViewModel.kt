package com.example.bilan.viewmodels

import android.app.Application
import androidx.lifecycle.*
import com.example.bilan.database.FitnessDatabase
import com.example.bilan.models.User
import com.example.bilan.repositories.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserViewModel @Inject constructor(
                    private val userRepository: UserRepository,savedStateHandle: SavedStateHandle
) : ViewModel() {

    val allUsers: Flow<List<User>> = userRepository.users

    suspend fun getUserById(id: Int): User? {
        return userRepository.getUserById(id)
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            userRepository.insertUser(user)
        }
    }

    fun updateUser(user: User) {
        viewModelScope.launch {
            userRepository.updateUser(user)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch {
            userRepository.deleteUser(user)
        }
    }
}
