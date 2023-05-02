package com.example.bilan.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bilan.models.User
import com.example.bilan.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch

class AjoutViewModel(private val userRepo: UserRepository = Graph.userRepo) : ViewModel() {

    private val _state = MutableStateFlow(AddUserViewState())
    val state: StateFlow<AddUserViewState>
        get() = _state

    fun addUser(user: User) {
        viewModelScope.launch {
            userRepo.insertUser(user)
        }
    }

}

data class AddUserViewState(
    val addUserSuccess: Boolean = false
)
