package com.bilan.objectifs

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.bilan.models.User

//Ndeye Mour Ndiaye

class MyActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

        }
    }
}

@Composable
fun MyScreen(onValidation: () -> Unit,user: User) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Text field
        Text(
            text = "Quelle zone de votre corps ciblez-vous?",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )

        // Options
        val options = listOf("Bras", "Abs", "Butt", "Pied", "Tout le corps")
        var selectedOption by remember { mutableStateOf("") }
        val scale by animateFloatAsState(
            targetValue = if (selectedOption.isNotEmpty()) 1.2f else 1f
        )
        options.forEach { option ->
            OptionItem(
                text = option,
                isSelected = option == selectedOption,
                onSelected = {
                    selectedOption = option
                }
            )
            Spacer(modifier = Modifier.height(16.dp))
        }

        // Button
        Button(
            onClick = {
                if (selectedOption.isNotEmpty()) {
                    onValidation()
                }
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Suivant",
                style = Typography().button,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

@Composable
fun OptionItem(text: String, isSelected: Boolean, onSelected: () -> Unit) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(8.dp))
            .background(if (isSelected) Color(0xFFFFCDD2) else MaterialTheme.colors.surface)
            .border(
                2.dp,
                if (isSelected) Color(0xFFF44336) else MaterialTheme.colors.onSurface,
                RoundedCornerShape(8.dp)
            )
            .clickable { onSelected() },
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = text,
            fontWeight = FontWeight.Bold,
            fontSize = 24.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(16.dp)
        )
    }
}


