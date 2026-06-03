package com.example.eventmaster.presentation.auth

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.eventmaster.R
import com.example.eventmaster.presentation.navigation.HomeRoute
import com.example.eventmaster.presentation.navigation.LoginRoute
import com.example.eventmaster.presentation.navigation.RegisterRoute
import com.example.eventmaster.ui.theme.EventPurple
import com.example.eventmaster.ui.theme.TextColor

@Composable
fun LoginScreen(
    navController: NavHostController,
    authViewModel: AuthViewModel = hiltViewModel(),
) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = androidx.compose.ui.Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))

        // Logo de la app
        androidx.compose.foundation.Image(
            painter = painterResource(id = R.drawable.ic_launcher_foreground),
            contentDescription = stringResource(R.string.app_name),
            modifier = Modifier
                .size(120.dp)
                .padding(bottom = 24.dp)
        )

        Text(
            text = stringResource(R.string.login_title),
            style = MaterialTheme.typography.headlineSmall,
            color = TextColor,
            modifier = Modifier.padding(bottom = 24.dp)
        )

        OutlinedTextField(
            value = email,
            onValueChange = { email = it; errorMessage = null },
            label = { Text(stringResource(R.string.email_label), color = TextColor) },
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = androidx.compose.ui.text.TextStyle(color = TextColor),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = EventPurple,
                unfocusedBorderColor = EventPurple.copy(alpha = 0.5f),
                focusedLabelColor = EventPurple,
                unfocusedLabelColor = TextColor.copy(alpha = 0.7f),
                cursorColor = EventPurple,
            )
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it; errorMessage = null },
            label = { Text(stringResource(R.string.password_label), color = TextColor) },
            visualTransformation = PasswordVisualTransformation(),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            textStyle = androidx.compose.ui.text.TextStyle(color = TextColor),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = EventPurple,
                unfocusedBorderColor = EventPurple.copy(alpha = 0.5f),
                focusedLabelColor = EventPurple,
                unfocusedLabelColor = TextColor.copy(alpha = 0.7f),
                cursorColor = EventPurple,
            )
        )

        Spacer(modifier = Modifier.height(20.dp))

        Button(
            onClick = {
                when {
                    email.isBlank() -> errorMessage = "El email es requerido"
                    password.isBlank() -> errorMessage = "La contraseña es requerida"
                    else -> {
                        authViewModel.login(email, password) { success ->
                            if (success) {
                                navController.navigate(HomeRoute) {
                                    popUpTo<LoginRoute> { inclusive = true }
                                }
                            } else {
                                errorMessage = "Email o contraseña incorrectos"
                            }
                        }
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = EventPurple,
                contentColor = Color(0xFF1A0B2E)
            ),
            shape = androidx.compose.foundation.shape.RoundedCornerShape(10.dp)
        ) {
            Text(
                text = stringResource(R.string.login_button),
                style = MaterialTheme.typography.labelLarge
            )
        }

        errorMessage?.let { msg ->
            Spacer(modifier = Modifier.height(12.dp))
            Text(text = msg, color = Color(0xFFFF6B6B))
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextButton(
            onClick = { navController.navigate(RegisterRoute) },
            modifier = Modifier.fillMaxWidth(),
        ) {
            Text(
                stringResource(R.string.go_to_register),
                color = EventPurple,
                style = MaterialTheme.typography.bodyMedium
            )
        }

        Spacer(modifier = Modifier.weight(1f))
    }
}
