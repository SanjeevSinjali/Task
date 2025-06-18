package com.example.inventoryapp.ui.theme.screens


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.inventoryapp.viewmodel.ProductViewModel
import com.example.inventoryapp.model.Product

@Composable
fun ProductScreen(viewModel: ProductViewModel = viewModel()) {
    var name by remember { mutableStateOf("") }
    var quantity by remember { mutableStateOf("") }

    Column(modifier = Modifier.padding(16.dp)) {
        TextField(value = name, onValueChange = { name = it }, label = { Text("Product Name") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = quantity, onValueChange = { quantity = it }, label = { Text("Quantity") })
        Spacer(modifier = Modifier.height(8.dp))
        Button(onClick = {
            if (name.isNotBlank() && quantity.isNotBlank()) {
                viewModel.addProduct(name, quantity.toIntOrNull() ?: 0)
                name = ""
                quantity = ""
            }
        }) {
            Text("Add Product")
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn {
            items(viewModel.products) { product ->
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Text("${product.name} - ${product.quantity}")
                    Button(onClick = { viewModel.deleteProduct(product) }) {
                        Text("Delete")
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}
