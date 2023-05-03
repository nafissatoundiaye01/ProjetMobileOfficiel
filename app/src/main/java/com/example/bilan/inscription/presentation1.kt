package com.bilan.objectifs

import android.os.Bundle
import androidx.activity.compose.setContent

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.scale
import androidx.compose.ui.input.key.Key.Companion.R
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp



//Ndeye Mour Ndiaye



@Composable
fun Presentation1Screen(Presentation:()->Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Image with circle frame
        val imageSize = 200.dp
        Box(
            modifier = Modifier
                .size(imageSize)
                .clip(CircleShape)
                .border(2.dp, MaterialTheme.colors.primary, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Image(
                painter = painterResource(com.example.bilan.R.drawable.presentation1),
                contentDescription = "Your Image",
                contentScale = ContentScale.Crop,
                modifier = Modifier.size(imageSize)
            )
        }

        // Text with animation
        val textScale by animateFloatAsState(targetValue = 1.2f)


        Text(
            text = "Salut ! Je suis votre  coach personnel. Voici quelques questions pour élaborer un plan personnel pour vous.",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .scale(textScale)
        )

        // Button
        Button(
            onClick = { /* TODO: Handle button click */ Presentation()},
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = "Je suis prêt",
                style = Typography().button,
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
    }
}

