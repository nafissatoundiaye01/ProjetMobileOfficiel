package com.bilan.objectifs

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bilan.database.User
import com.example.bilan.database.UserViewModel

//Ndeye Mour Ndiaye

class GenreActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Surface(color = MaterialTheme.colors.background) {
                GenderScreen { user ->
                    // Ajouter les données de l'utilisateur dans la base de données
                }
            }
        }
    }
}


@Composable
fun GenderScreen(onOption: (User) -> Unit)

{
    val viewModel = viewModel(UserViewModel::class.java)
    val state by viewModel.state.collectAsState()
    var chosenState by remember {
        mutableStateOf<Boolean?>(null)

    }
    fun addUser(genderSelected: Boolean): User {
        return User(
            0,
            if (genderSelected) "homme" else "femme",
        )
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Quel est votre genre?",
            fontWeight = FontWeight.Bold,
            fontSize = MaterialTheme.typography.h5.fontSize,
            modifier = Modifier.padding(16.dp)
        )
        GenderOption(
            imageId = com.example.bilan.R.drawable.homme,
            text = "Homme",
            isSelected = chosenState == true,
            onClick = {
                chosenState = true
            }
        )
        GenderOption(
            imageId = com.example.bilan.R.drawable.femme,
            text = "Femme",
            isSelected = chosenState == false,
            onClick = {
                chosenState = false
            }
        )
        Button(
            onClick = {

                chosenState?.let { genderSelected ->
                    viewModel.insertUser(addUser(genderSelected))
                    Log.d("Message","${state.userList}")
                    onOption(addUser(genderSelected)) // création d'un objet User avec le genre sélectionné et ajout à la base de données
                }
            },
            modifier = Modifier.padding(16.dp),
            shape = RoundedCornerShape(16.dp),
            enabled = chosenState != null
        ) {
            Text(text = "Suivant")
        }
    }
}


@Composable
fun GenderOption(imageId: Int, text: String, isSelected: Boolean, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(120.dp)
                .clickable(onClick = onClick)
                .background(
                    if (isSelected)
                        MaterialTheme.colors.primary.copy(alpha = 0.3f)
                    else
                        Color.Transparent
                )
        ) {
            Image(
                painter = painterResource(id = imageId),
                contentDescription = text,
                contentScale = ContentScale.FillBounds,
                modifier = Modifier.size(80.dp)
            )
        }
        Text(
            text = text,
            fontWeight = FontWeight.Bold,


            fontSize = MaterialTheme.typography.h6.fontSize,
            modifier = Modifier.padding(8.dp)
        )
    }
}





@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GenderScreenPreview() {
    // GenderScreen()
}