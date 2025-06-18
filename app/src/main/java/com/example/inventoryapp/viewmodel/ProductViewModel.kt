package com.example.inventoryapp.viewmodel


import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.inventoryapp.model.Product

class ProductViewModel : ViewModel() {
    private val _products = mutableStateListOf<Product>()
    val products: List<Product> = _products

    fun addProduct(name: String, quantity: Int) {
        val newProduct = Product(id = _products.size + 1, name = name, quantity = quantity)
        _products.add(newProduct)
    }

    fun updateProduct(updated: Product) {
        val index = _products.indexOfFirst { it.id == updated.id }
        if (index != -1) _products[index] = updated
    }

    fun deleteProduct(product: Product) {
        _products.remove(product)
    }
}
