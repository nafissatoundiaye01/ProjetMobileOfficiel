package com.example.bilan.viewmodels


import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bilan.maintenance.MiseAJourEntrainements
import com.example.bilan.models.Entrainements
import com.example.bilan.models.User
import com.example.bilan.models.UserSession
import com.example.bilan.repositories.EntrainementsRepository
import com.example.bilan.repositories.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.launch


class BilanViewModel(private val userRepo: UserRepository = Graph.userRepo, private val entrainementsRepo: EntrainementsRepository =Graph.entrainementsRepo) : ViewModel() {
    val userSessionClass= UserSession()
    val userSession:User = userSessionClass.getSession()
    private val _state = MutableStateFlow(BilanViewState())
    val state: StateFlow<BilanViewState>
        get() = _state
    val userList = userRepo.users
    val selected = MutableStateFlow(_state.value.selected)
    val joursSemaine = listOf("Lundi", "Mardi", "Mercredi", "Jeudi", "Vendredi", "Samedi", "Dimanche")

    init {
        viewModelScope.launch {
            combine(userList, selected) { usersList: List<User>, selected: Boolean ->
                val entrainemantsWeekList = entrainementsRepo.getAllEntrainementsWeek(userSession.id)
                val entrainementsAllDayWeek = mutableListOf<Entrainements>()
                for (element in joursSemaine) {
                    val entrainement = entrainementsRepo.getEntrainementsByDate(userSession.id,element)
                    entrainementsAllDayWeek.add(entrainement)

                }

                BilanViewState(usersList, selected,entrainemantsWeekList,entrainementsAllDayWeek)
            }.collect {
                _state.value = it
            }
        }
    }

suspend fun update(element:Entrainements){
    entrainementsRepo.updateEntrainements(element)
}

}

data class BilanViewState(
    val usersList: List<User> = emptyList(),
    val selected: Boolean = false,
    val entrainemantsWeekList: List<Entrainements> = emptyList(),
    val entrainementsAllDayWeek : List<Entrainements> = emptyList()
)

