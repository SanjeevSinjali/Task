package com.example.inventoryapp.ui.theme.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(true) {
        Handler(Looper.getMainLooper()).postDelayed({
            navController.navigate("login") {
                popUpTo("splash") { inclusive = true }
            }
        }, 2000)
    }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Text(text = "Inventory App")
    }
}
