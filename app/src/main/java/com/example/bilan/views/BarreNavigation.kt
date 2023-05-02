package com.example.bilan.views

import android.annotation.SuppressLint
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bilan.models.User
import com.example.bilan.viewmodels.UserViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import androidx.hilt.navigation.compose.hiltViewModel

import kotlinx.coroutines.flow.emptyFlow
import kotlinx.coroutines.withContext

@Composable
fun BarreNavigation(viewModel : UserViewModel = hiltViewModel()) {
    val user = User(0,"Nafissatou","Ndiaye","Femme","ventre","perte de poids",80.0,168.0,70.0,"nafissatound1@gmail.com","nafi2023")

            viewModel.addUser(user)


    Text(text = "C'est bon! ")


    Text(text = "getNom()")
}
@Composable
 fun getNom(viewModel : UserViewModel = hiltViewModel()):String{
    var users = emptyFlow<List<User>>()
var nom=""

            users = viewModel.allUsers


    return nom
}