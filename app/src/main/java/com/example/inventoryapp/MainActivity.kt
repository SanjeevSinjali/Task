package com.example.inventoryapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.example.inventoryapp.ui.theme.InventoryAppTheme
import com.example.inventoryapp.ui.theme.Navigation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            InventoryAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "Inventory App")
                }
            )
        },
        bottomBar = {
            BottomAppBar {
                Text(
                    text = "© 2025 InventoryApp",
                    modifier = androidx.compose.ui.Modifier.padding(16.dp)
                )
            }
        },
        content = { padding ->
            // Navigation composable should handle padding
            Navigation(modifier = androidx.compose.ui.Modifier.padding(padding))
        }
    )
}
