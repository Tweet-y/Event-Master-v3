package com.example.eventmaster

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import com.example.eventmaster.presentation.navigation.EventMasterNavigation
import com.example.eventmaster.ui.theme.EventMasterTheme

import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EventMasterTheme {
                EventMasterMainScreen()
            }
        }
    }
}

@Composable
fun EventMasterMainScreen() {
    EventMasterNavigation()
}