package com.loubna.imc_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.loubna.imc_app.ui.theme.IMCAppTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        setContent {
            IMCAppTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize()
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

    Column(modifier = modifier) {

        Text(text = "Calcular BMI")

        TextField(
            value = nom,
            onValueChange = { nom = it },
            label = {
                Text(text = "Nom")
            })

        Row {

            Text(text = "Pes: $pes kg")

            Button(
                onClick = {
                    if (pes > 1) {
                        pes--
                    }
                }) {
                Text(text = "-")
            }

            Button(
                onClick = {
                    pes++
                }) {
                Text(text = "+")
            }
        }

        Text(text = "Alçada: $alcada cm")

        Slider(
            value = alcada.toFloat(), onValueChange = {
                alcada = it.toInt()
            }, valueRange = 100f..250f
        )

        Button(
            onClick = {

                if (nom.isNotBlank()) {

                    val alcadaMetres = alcada / 100f

                    bmi = pes / (alcadaMetres * alcadaMetres)
                }
            }) {
            Text(text = "Calcular BMI")
        }

        if (bmi != 0f) {

            Text(text = "IMC de $nom")

            Text(text = "IMC: $bmi")
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