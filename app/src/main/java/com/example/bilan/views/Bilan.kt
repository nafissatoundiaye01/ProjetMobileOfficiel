package com.example.bilan.views


import android.annotation.SuppressLint
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.bilan.maintenance.MiseAJourEntrainements
import com.example.bilan.models.User
import com.example.bilan.models.UserSession
import com.example.bilan.viewmodels.BilanViewModel
import com.example.bilan.viewmodels.Graph
import java.time.LocalDate


@SuppressLint("SuspiciousIndentation")
@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun MyView() {


    val userSessionClass= UserSession()
    val userSession:User = userSessionClass.getSession()
    val user1 = User(0,"Nafissatou","NDIAYE","Femme","ventre","perte poids",80.0,1.65,65.0,72.0,"nafissatound1@gmail.com","nafi")
    val viewModel = viewModel(BilanViewModel::class.java)
    val state by viewModel.state.collectAsState()
    val dateAujourdhui = LocalDate.now()
    val maj = MiseAJourEntrainements()
    maj.createWeeklyWorkoutsIfMonday()


    //variablesUtiles
    var dureeSemaine = 0
    for(element in state.entrainemantsWeekList){
        dureeSemaine += element.duree
    }
    var dureeJour=0
    for(element in state.entrainementsAllDayWeek){
        if(element.date==dateAujourdhui){
            dureeJour=element.duree
        }
    }
    var caloriesSemaine = 0.0
    for(element in state.entrainemantsWeekList){
        caloriesSemaine += element.calories
    }
    var caloriesJour=0.0
    for(element in state.entrainementsAllDayWeek){
        if(element.date==dateAujourdhui){
            caloriesJour = element.calories
        }
    }
    val dureeAllDayWeek = mutableListOf<Int>()
    for (element in state.entrainementsAllDayWeek) {
        val duree = element.duree
        dureeAllDayWeek.add(duree)

    }
    val calorieAllDayWeek = mutableListOf<Double>()
    for (element in state.entrainementsAllDayWeek) {
        val calorie = element.calories
        calorieAllDayWeek.add(calorie)

    }


        LazyColumn(
            modifier = Modifier
                .background(Color.Black)



        ) {
            items(1) {


                BottomNavigationBar()
                Spacer(Modifier.height(10.dp))

                Box(
                    Modifier
                        .width(420.dp)
                        .height(200.dp)
                        .background(Color.Black)
                        .padding(10.dp)
                ) {
                    Row() {
                        Box(
                            Modifier
                                .width(185.dp)
                                .height(200.dp)
                                .background(Color.DarkGray, RoundedCornerShape(16.dp))
                                .padding(16.dp)
                        ){
                            val annotatedString = buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.White, fontSize = 16.sp,  fontWeight = FontWeight.Bold)) {
                                    append("Entrainements ")
                                }
                                withStyle(style = SpanStyle(color = Color.LightGray)) {
                                    append("(min)")
                                }
                                withStyle(style = SpanStyle(color = Color.LightGray, fontSize = 35.sp,fontWeight = FontWeight.Bold)) {
                                    append(" \n$dureeJour")
                                }
                                withStyle(style = SpanStyle(color = Color.LightGray, fontSize = 16.sp)) {
                                    append("\nTotal \n \nCette Semaine: ")
                                }
                                withStyle(style = SpanStyle(color = Color.LightGray, fontSize = 16.sp, fontWeight = FontWeight.Bold)) {
                                    append("$dureeSemaine")
                                }


                            }
                            Text(
                                text=annotatedString,
                            )
                        }
                        Spacer(Modifier.width(16.dp))
                        Box(
                            Modifier
                                .width(190.dp)
                                .height(200.dp)
                                .background(Color.DarkGray, RoundedCornerShape(16.dp))
                                .padding(16.dp)
                        ){
                            val annotatedString = buildAnnotatedString {
                                withStyle(style = SpanStyle(color = Color.White, fontSize = 16.sp,  fontWeight = FontWeight.Bold)) {
                                    append("Calories ")
                                }
                                withStyle(style = SpanStyle(color = Color.LightGray)) {
                                    append("(Kcal)")
                                }
                                withStyle(style = SpanStyle(color = Color.LightGray, fontSize = 35.sp,fontWeight = FontWeight.Bold)) {
                                    append(" \n$caloriesJour")
                                }
                                withStyle(style = SpanStyle(color = Color.LightGray, fontSize = 16.sp)) {
                                    append("\nTotal \n \nCette Semaine: ")
                                }
                                withStyle(style = SpanStyle(color = Color.LightGray, fontSize = 16.sp, fontWeight = FontWeight.Bold)) {
                                    append(" $caloriesSemaine")
                                }


                            }
                            Text(
                                text=annotatedString,
                            )
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Box(
                    Modifier
                        .width(420.dp)
                        .height(330.dp)
                        .background(Color.Black)
                        .padding(10.dp)
                ) {
                    Row() {
                        Box(
                            Modifier
                                .width(185.dp)
                                .height(330.dp)
                                .background(Color.DarkGray, RoundedCornerShape(16.dp))
                                .padding(16.dp)
                        ){

                                var cupsDrunk by remember { mutableStateOf(0) }

                                val strokeColor = Color.White
                                val strokeWidth = 12.dp
                                val totalCups = 8
                                Text(text = "\uD83D\uDCA6 Suivi de Consommation D'eau", color=Color.White, fontSize=16.sp,fontWeight=FontWeight.Bold)
                                Canvas(
                                    modifier = Modifier
                                        .size(210.dp)
                                        .padding(16.dp)
                                        .offset(y = 20.dp),
                                    onDraw = {
                                        val radius = size.minDimension / 2 - strokeWidth.toPx() / 2
                                        val center = Offset(size.width / 2, size.height / 2)
                                        val anglePerCup = 360f / totalCups
                                        val cupsLeft = totalCups - cupsDrunk

                                        for (i in 0 until totalCups) {
                                            val startAngle = i * anglePerCup - 90
                                            val sweepAngle = anglePerCup * 0.9f
                                            drawArc(
                                                //stroke = Stroke(width = strokeWidth.toPx()),
                                                color = strokeColor,
                                                startAngle = startAngle,
                                                sweepAngle = sweepAngle,
                                                useCenter = false,
                                                topLeft = Offset(center.x - radius, center.y - radius),
                                                size = Size(radius * 2, radius * 2)
                                            )
                                        }
                                        for (i in 0 until cupsDrunk) {
                                            val startAngle = i * anglePerCup - 90
                                            val sweepAngle = anglePerCup * 0.9f
                                            drawArc(
                                                color = Color.Cyan,
                                                startAngle = startAngle,
                                                sweepAngle = sweepAngle,
                                                useCenter = false,
                                                topLeft = Offset(center.x - radius, center.y - radius),
                                                size = Size(radius * 2, radius * 2)
                                            )
                                        }
                                    }
                                )
                                Column(
                                    horizontalAlignment = Alignment.CenterHorizontally,
                                    modifier = Modifier.padding(top = 16.dp)
                                ) {
                                    val annotatedString = buildAnnotatedString {
                                        withStyle(
                                            style = SpanStyle(
                                                fontSize = 20.sp,
                                                fontWeight = FontWeight.Bold,

                                                )
                                        ) {
                                            append("\r\r\uD83D\uDCA7")
                                        }
                                        withStyle(
                                            style = SpanStyle(
                                                color = Color.White,
                                                fontSize = 30.sp,
                                                fontWeight = FontWeight.Bold,

                                            )
                                        ) {
                                            append("\n\r\r$cupsDrunk ")
                                        }
                                        withStyle(style = SpanStyle(color = Color.LightGray)) {
                                            append("\n/8 Tasses")
                                        }
                                    }
                                    Text(text=annotatedString,modifier=Modifier.offset(x=40.dp,y=55.dp))
                                    Row {
                                        Button(
                                            onClick = {
                                                cupsDrunk = cupsDrunk - 1

                                            },modifier= Modifier
                                                .size(40.dp)

                                                .offset(x = 30.dp, y = 120.dp),
                                            shape = RoundedCornerShape(100)

                                        ) {
                                            Text("-")
                                        }
                                        Button(
                                            onClick = {
                                                cupsDrunk = cupsDrunk + 1

                                            }, modifier = Modifier
                                                .size(40.dp)
                                                .offset(x = 35.dp, y = 120.dp),
                                            shape = RoundedCornerShape(100)

                                        ) {
                                            Text("+")
                                        }
                                    }

                                }


                            }




                        Spacer(Modifier.width(16.dp))
                        Box(
                            Modifier
                                .width(190.dp)
                                .height(350.dp)
                                .background(Color.DarkGray, RoundedCornerShape(16.dp))
                                .padding(16.dp)
                        ){
                            StepProgressCircular()
                        }
                    }
                }
                Spacer(Modifier.height(16.dp))
                Box(
                    Modifier
                        .width(410.dp)
                        .height(200.dp)
                        .background(Color.DarkGray, RoundedCornerShape(16.dp))
                        .padding(16.dp)
                        .offset(10.dp)
                ){
                    Text(text = "\u23F0 Entrainements: $dureeSemaine min", fontWeight = FontWeight.Bold,fontSize=20.sp,color=Color.White)
                    val maxTime = 180

                    Row(modifier=Modifier.height(400.dp)) {
                        dureeAllDayWeek.forEachIndexed { index, time ->
                            Column(
                                //  horizontalAlignment  = Horizontal ,
                                modifier = Modifier
                                    .height(400.dp)
                                    .width(55.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(400.dp)
                                        .weight(1f)
                                        .offset(y = 50.dp)
                                        .padding(horizontal = 4.dp),
                                    contentAlignment = Alignment.BottomCenter
                                ) {
                                    Canvas(
                                        modifier = Modifier.size(
                                            width = 8.dp,
                                            height = 100.dp
                                        )
                                    ) {
                                        drawRect(
                                            color = Color.Gray,
                                            size = size
                                        )

                                        drawRect(
                                            color = Color.Blue,
                                            size = Size(
                                                size.width,
                                                size.height * (time / maxTime)
                                            )
                                        )
                                    }
                                }

                                Text(
                                    text = when (index) {
                                        0 -> "Lun"
                                        1 -> "Mar"
                                        2 -> "Mer"
                                        3 -> "Jeu"
                                        4 -> "Ven"
                                        5 -> "Sam"
                                        else -> "Dim"
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .offset(y = 50.dp)
                                        .padding(start = 4.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }

                }
                Spacer(Modifier.height(16.dp))
                Box(
                    Modifier
                        .width(420.dp)
                        .height(200.dp)
                        .background(Color.DarkGray, RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ){
                    Text(text = "\uD83D\uDD25 Calories: $caloriesSemaine Kcal", fontWeight = FontWeight.Bold,fontSize=20.sp,color=Color.White)
                    val maxSteps = 3000.0

                    Row(modifier=Modifier.height(400.dp)) {
                        calorieAllDayWeek.forEachIndexed { index, steps ->
                            Column(
                                //  horizontalAlignment  = Horizontal ,
                                modifier = Modifier
                                    .height(400.dp)
                                    .width(55.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .height(400.dp)
                                        .weight(1f)
                                        .offset(y = 50.dp)
                                        .padding(horizontal = 4.dp),
                                    contentAlignment = Alignment.BottomCenter
                                ) {
                                    Canvas(
                                        modifier = Modifier.size(
                                            width = 8.dp,
                                            height = 100.dp
                                        )
                                    ) {
                                        drawRect(
                                            color = Color.Gray,
                                            size = size
                                        )

                                        drawRect(
                                            color = Color.Blue,
                                            size = Size(
                                                size.width,
                                                (size.height * (steps / maxSteps)).toFloat()
                                            )
                                        )
                                    }
                                }

                                Text(
                                    text = when (index) {
                                        0 -> "Lun"
                                        1 -> "Mar"
                                        2 -> "Mer"
                                        3 -> "Jeu"
                                        4 -> "Ven"
                                        5 -> "Sam"
                                        else -> "Dim"
                                    },
                                    modifier = Modifier
                                        .weight(1f)
                                        .offset(y = 50.dp)
                                        .padding(start = 4.dp),
                                    textAlign = TextAlign.Start,
                                    fontSize = 18.sp,
                                    color = Color.White
                                )
                            }
                        }
                    }

                }
                Spacer(Modifier.height(16.dp))
                Box(
                    Modifier
                        .width(420.dp)
                        .height(200.dp)
                        .background(Color.DarkGray, RoundedCornerShape(16.dp))
                        .padding(16.dp)
                ){
                    Column(){
                    val poidsD= userSession.poidsDebut
                    val poidsO= userSession.poidsObjectif
                    val poidsA = userSession.poidsActuel
                    val perc= (((poidsD-poidsA).toDouble()/(poidsD-poidsO).toDouble())*100).toInt()
                    Text(text = "\uD83C\uDFAF Objectifs", fontWeight = FontWeight.Bold,fontSize=20.sp,color=Color.White)
                    Text("\n Poids Début: $poidsD Kg;\r Poids Objectif: $poidsO Kg",fontSize=15.sp,color=Color.Gray)
                    if((poidsA-poidsO)==0.0) {
                        Text("\n Bravo, Vous Avez Atteint votre Objectif!",fontSize=15.sp,color=Color.Gray)
                    }
                    if((poidsA-poidsO)<10){
                        Text("\n Un petit effort, Vous allez bientôt y arriver!",fontSize=15.sp,color=Color.Gray)
                    }
                    if((poidsA-poidsO>10)){
                        Text("\n Courage, Vous y arriverez!",fontSize=15.sp,color=Color.Gray)
                    }
                        Text("\n Vous avez atteint $perc% de votre objectif: Poids Actuel $poidsA Kg",fontSize=15.sp,color=Color.Gray)


                    }
                }
            }
        }


    }

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun StepProgressCircular() {
    var steps by remember { mutableStateOf(0) }
    val viewModel = viewModel(BilanViewModel::class.java)
    val state by viewModel.state.collectAsState()

    val dateAujourdhui = LocalDate.now()
    LaunchedEffect(dateAujourdhui) {
        state.entrainemantsWeekList.forEach { element ->
            if(element.date == dateAujourdhui){
                element.calories = (0.5 + element.calories)
                viewModel.update(element)
            }
        }
    }
    val sensorListener = object : SensorEventListener {
        override fun onAccuracyChanged(sensor: Sensor?, accuracy: Int) {}

        override fun onSensorChanged(event: SensorEvent?) {
            if (event?.sensor?.type == Sensor.TYPE_STEP_COUNTER) {
                steps = event.values[0].toInt()

            }
        }
    }
    val sensorManager = LocalContext.current.getSystemService(SensorManager::class.java)
    val stepSensor = sensorManager.getDefaultSensor(Sensor.TYPE_STEP_COUNTER)

    DisposableEffect(key1 = sensorManager, key2 = stepSensor) {
        sensorManager.registerListener(sensorListener, stepSensor, SensorManager.SENSOR_DELAY_NORMAL)
        onDispose {
            sensorManager.unregisterListener(sensorListener)
        }
    }
    val strokeColor = Color.White
    val strokeWidth = 12.dp
    val totalSteps = 2500
    Text(text = "\uD83D\uDC63 Tracker De Pas", color=Color.White, fontSize=16.sp,fontWeight=FontWeight.Bold)
    Canvas(
        modifier = Modifier
            .size(210.dp)
            .padding(16.dp)
            .offset(y = 20.dp),
        onDraw = {
            val radius = size.minDimension / 2 - strokeWidth.toPx() / 2
            val center = Offset(size.width / 2, size.height / 2)
            val anglePerCup = 360f / totalSteps
            val stepLeft = totalSteps - steps

            for (i in 0 until totalSteps) {
                val startAngle = i * anglePerCup - 90
                val sweepAngle = anglePerCup * 0.9f
                drawArc(
                    //stroke = Stroke(width = strokeWidth.toPx()),
                    color = strokeColor,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    topLeft = Offset(center.x - radius, center.y - radius),
                    size = Size(radius * 2, radius * 2)
                )
            }
            for (i in 0 until steps) {
                val startAngle = i * anglePerCup - 90
                val sweepAngle = anglePerCup * 0.9f
                drawArc(
                    color = Color.Green,
                    startAngle = startAngle,
                    sweepAngle = sweepAngle,
                    useCenter = false,
                    topLeft = Offset(center.x - radius, center.y - radius),
                    size = Size(radius * 2, radius * 2)
                )
            }
        }
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 16.dp)
    ) {
        val annotatedString = buildAnnotatedString {
            withStyle(
                style = SpanStyle(
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,

                    )
            ) {
                append("\r\r\uD83D\uDEB6")
            }
            withStyle(
                style = SpanStyle(
                    color = Color.White,
                    fontSize = 30.sp,
                    fontWeight = FontWeight.Bold,

                    )
            ) {
                append("\n\r\r$steps ")
            }
            withStyle(style = SpanStyle(color = Color.LightGray)) {
                append("\n/2500 Pas")
            }
        }
        Text(text=annotatedString,modifier=Modifier.offset(x=5.dp,y=55.dp))
        Text("Suivez les pas quotidiens et Gardez la Motivation ",modifier=Modifier.offset(x=10.dp,y=100.dp),color=Color.Gray)

    }


}


@RequiresApi(Build.VERSION_CODES.O)
@Preview
@Composable
fun MyViewPreview() {
    MyView()
}
