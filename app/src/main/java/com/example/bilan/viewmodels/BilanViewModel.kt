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


class BilanViewModel(private val userRepo: UserRepository = Graph.userRepo) : ViewModel() {
    private val _state = MutableStateFlow(BilanViewState())
    val state: StateFlow<BilanViewState>
        get() = _state

    val userList = userRepo.users
    val selected = MutableStateFlow(_state.value.selected)

    init {
        viewModelScope.launch {
            combine(userList, selected) { usersList: List<User>, selected: Boolean ->
                BilanViewState(usersList, selected)
            }.collect {
                _state.value = it
            }
        }
    }



}

data class BilanViewState(
    val usersList: List<User> = emptyList(),
    val selected: Boolean = false,
)

