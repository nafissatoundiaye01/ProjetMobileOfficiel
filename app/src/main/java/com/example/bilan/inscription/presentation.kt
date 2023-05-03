package com.bilan.objectifs


import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.animation.core.*
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.StrokeCap
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

//Ndeye Mour Ndiaye

class PresentationActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
           // PresentationScreen()
        }
    }
}

@Composable
fun PresentationScreen(onGenre:()->Unit) {
    Surface(color = MaterialTheme.colors.background) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            AnimatedArrow()
            Spacer(modifier = Modifier.height(32.dp))
            Text(
                text = "Goals and Focus",
                style = TextStyle(fontSize = 24.sp),
                modifier = Modifier.padding(top = 16.dp)
            )
            Spacer(modifier = Modifier.height(32.dp))
            Button(onClick = {
                onGenre()
            }, modifier = Modifier.align(Alignment.End)) {
                Text(text = "Next")
            }
        }
    }
}

@Composable
fun AnimatedArrow() {
    var arrowPosition by remember { mutableStateOf(0f) }

    val infiniteTransition = rememberInfiniteTransition()
    val animatedArrowPosition = infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 40f,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 500, easing = LinearEasing),
            repeatMode = RepeatMode.Reverse
        )
    )

    Canvas(
        modifier = Modifier.size(48.dp)
    ) {
        drawLine(
            color = Color.Black,
            start = Offset(x = 0f, y = arrowPosition),
            end = Offset(x = 24f, y = arrowPosition + 24f),
            strokeWidth = 4.dp.toPx(),
            cap = StrokeCap.Round
        )

        drawLine(
            color = Color.Black,
            start = Offset(x = 24f, y = arrowPosition + 24f),
            end = Offset(x = 48f, y = arrowPosition),
            strokeWidth = 4.dp.toPx(),
            cap = StrokeCap.Round
        )
    }

    arrowPosition = animatedArrowPosition.value
}
