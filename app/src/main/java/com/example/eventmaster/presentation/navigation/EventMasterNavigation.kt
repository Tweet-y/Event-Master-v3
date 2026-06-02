package com.example.eventmaster.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eventmaster.ui.navigation.EventMasterNavGraph
import com.example.eventmaster.presentation.auth.AuthViewModel
import com.example.eventmaster.presentation.auth.LoginScreen

@Composable
fun EventMasterNavigation(
    authViewModel: AuthViewModel = hiltViewModel()
) {
    val navController = rememberNavController()
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()

    // 1. Mostrar pantalla de carga limpia mientras DataStore responde de forma asíncrona
    if (isLoggedIn == null) {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
        return
    }

    // 2. Determinar dinámicamente el destino de inicio real
    val startDestination = if (isLoggedIn == true) HomeRoute else LoginRoute

    NavHost(
        navController = navController,
        startDestination = startDestination
    ) {
        composable<LoginRoute> {
            LoginScreen(navController = navController, authViewModel = authViewModel)
        }

        composable<HomeRoute> {
            EventMasterNavGraph(navController = navController)
        }
    }
}

