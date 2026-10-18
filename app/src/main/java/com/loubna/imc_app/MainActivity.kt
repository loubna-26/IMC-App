package com.loubna.imc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.loubna.imc_app.ui.theme.IMCAppTheme

// Paleta
private val Navy = Color(0xFF1B365D)
private val Sand = Color(0xFFFBE8C4)
private val Gold = Color(0xFF8B6914)
private val Cream = Color(0xFFF7F5F0)
private val DarkText = Color(0xFF2B1B0E)

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            IMCAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    containerColor = Cream
                ) { innerPadding ->
                    // Pasamos innerPadding como Modifier.padding a BMIScreen
                    BMIScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun BMIScreen(modifier: Modifier = Modifier) {

    var nom by remember { mutableStateOf("") }
    var pes by remember { mutableIntStateOf(80) }
    var alcada by remember { mutableIntStateOf(160) }
    var bmi by remember { mutableFloatStateOf(0f) }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {

        // Títol
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = "Índex de Massa Corporal",
                fontFamily = FontFamily.Serif,
                fontWeight = FontWeight.Bold,
                fontSize = 28.sp,
                textAlign = TextAlign.Center,
                color = Navy
            )
            Text(
                text = "Càlcul clàssic i elegant de salut",
                fontSize = 13.sp,
                color = Gold
            )
        }

        // Targeta: nom
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier.padding(20.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                Text(
                    text = "Nom del usuari",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = DarkText
                )

                OutlinedTextField(
                    value = nom,
                    onValueChange = { nom = it },
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text(text = "Escriu el teu nom") },
                    shape = RoundedCornerShape(14.dp),
                    singleLine = true,
                    colors = OutlinedTextFieldDefaults.colors(
                        focusedBorderColor = Navy,
                        unfocusedBorderColor = Navy.copy(alpha = 0.3f),
                        cursorColor = Navy,
                        focusedTextColor = DarkText,
                        unfocusedTextColor = DarkText
                    )
                )
            }
        }

        // Targeta: pes
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Pes (kg)",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = DarkText
                )

                Text(
                    text = "$pes kg",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Navy
                )

                Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {

                    Button(
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Sand,
                            contentColor = Navy
                        ),
                        onClick = {
                            if (pes > 1) {
                                pes--
                            }
                        }) {
                        Text(text = "-", fontWeight = FontWeight.Bold)
                    }

                    Button(
                        shape = RoundedCornerShape(12.dp),
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Sand,
                            contentColor = Navy
                        ),
                        onClick = {
                            pes++
                        }) {
                        Text(text = "+", fontWeight = FontWeight.Bold)
                    }
                }
            }
        }

        // Targeta: alçada
        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(20.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White),
            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Alçada (cm)",
                    fontWeight = FontWeight.Medium,
                    fontSize = 14.sp,
                    color = DarkText
                )

                Text(
                    text = "$alcada cm",
                    fontFamily = FontFamily.Serif,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Navy
                )

                Slider(
                    value = alcada.toFloat(), onValueChange = {
                        alcada = it.toInt()
                    }, valueRange = 100f..250f,
                    colors = SliderDefaults.colors(
                        thumbColor = Navy,
                        activeTrackColor = Navy,
                        inactiveTrackColor = Sand
                    )
                )
            }
        }

        // Botó calcular
        Button(
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp),
            shape = RoundedCornerShape(16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Navy,
                contentColor = Color.White
            ),
            onClick = {

                if (nom.isNotBlank()) {

                    val alcadaMetres = alcada / 100f

                    bmi = pes / (alcadaMetres * alcadaMetres)
                }
            }) {
            Text(
                text = "CALCULAR BMI",
                fontWeight = FontWeight.Bold,
                fontSize = 14.sp,
                letterSpacing = 1.sp
            )
        }

        // Resultat
        if (bmi != 0f) {

            val categoria = when {
                bmi < 18.5f -> "Baix pes"
                bmi < 25f -> "Pes normal"
                bmi < 30f -> "Sobrepès"
                else -> "Obesitat"
            }

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(20.dp),
                colors = CardDefaults.cardColors(containerColor = Sand),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(24.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(4.dp)
                ) {

                    Text(
                        text = "Resultat per a $nom",
                        fontSize = 14.sp,
                        fontWeight = FontWeight.Medium,
                        color = DarkText
                    )

                    Text(
                        text = "%.1f".format(bmi),
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 48.sp,
                        color = DarkText
                    )

                    Text(
                        text = categoria,
                        fontFamily = FontFamily.Serif,
                        fontWeight = FontWeight.Bold,
                        fontSize = 20.sp,
                        color = Gold
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BMIScreenPreview() {
    IMCAppTheme {
        BMIScreen()
    }
}