package com.shg25.aitsu

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.shg25.aitsu.ui.theme.AitsuTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AitsuTheme {
                MyApp()
            }
        }
    }

    @Composable
    fun MyApp(){

    }
}
