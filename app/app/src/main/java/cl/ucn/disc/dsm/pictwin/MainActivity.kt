/*
 * Copyright (c) 2024. Departamento de Ingenieria de Sistemas y Computacion.
 */

package cl.ucn.disc.dsm.pictwin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import cl.ucn.disc.dsm.pictwin.ui.theme.PicTwinTheme

/**
 * The Main Activity.
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        // onCreate: build the UI (needs to be fast!)
        super.onCreate(savedInstanceState)

        // enableEdgeToEdge()

        setContent {
            PicTwinTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    CounterButton(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun CounterButton(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    PicTwinTheme {
        CounterButton("Android")
    }
}


