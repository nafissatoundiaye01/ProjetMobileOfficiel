package com.example.myapplication_conditionphysique.NiveaauSport



import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
//Ndeye Mour Ndiaye

class MyEquipementActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
           // MyEquipementActivity()
        }
    }
}

@Composable
fun MyEquipementScreen(onConnexion:()->Unit) {

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Disposez-vous d'équipement(corde,bande elastique,poids,etc..) ",
            modifier = Modifier.padding(16.dp)
        )

        Option(text = "Oui")
        Option(text = "Non")

        Button(
            onClick = {
                onConnexion()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = "Suivant")
        }
    }
}

@Composable
fun Option(text: String) {
    val selected = remember { mutableStateOf(false) }

    Text(
        text = text,
        modifier = Modifier
            .padding(16.dp)
            .animateContentSize()
            .clickable { selected.value = !selected.value }
            .padding(16.dp)
            .background(if (selected.value) MaterialTheme.colors.secondary else MaterialTheme.colors.surface)
            .padding(16.dp)
    )
}

@Preview
@Composable
fun MyEquipementScreenPreview() {
   // MyEquipementScreen()
}
