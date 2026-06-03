package com.example.eventmaster.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.eventmaster.presentation.auth.AuthViewModel
import com.example.eventmaster.presentation.auth.LoginScreen
import com.example.eventmaster.presentation.auth.RegisterScreen
import com.example.eventmaster.ui.navigation.EventMasterNavGraph

@Composable
fun EventMasterNavigation(
    authViewModel: AuthViewModel = hiltViewModel(),
) {
    val navController = rememberNavController()
    val isLoggedIn by authViewModel.isLoggedIn.collectAsState()

    if (isLoggedIn == null) {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            CircularProgressIndicator()
        }
        return
    }

    LaunchedEffect(isLoggedIn) {
        if (isLoggedIn == true) {
            navController.navigate(HomeRoute) {
                popUpTo(LoginRoute) { inclusive = true }
            }
        } else {
            navController.navigate(LoginRoute) {
                popUpTo(0) { inclusive = true }
            }
        }
    }

    NavHost(navController = navController, startDestination = LoginRoute) {
        composable<LoginRoute> {
            LoginScreen(navController = navController, authViewModel = authViewModel)
        }

        composable<RegisterRoute> {
            RegisterScreen(navController = navController, authViewModel = authViewModel)
        }

        composable<HomeRoute> {
            EventMasterNavGraph()
        }
    }
}