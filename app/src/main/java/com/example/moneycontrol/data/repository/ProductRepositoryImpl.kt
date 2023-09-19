package com.example.moneycontrol.data.repository

import com.example.moneycontrol.domain.models.Product
import com.example.moneycontrol.domain.repository.ProductRepository

class ProductRepositoryImpl : ProductRepository {

    override fun saveProduct(param: Product): Boolean {
        return true
    }

    override fun getProduct(): Product {
        return Product(title = "Молоко", price = "50")
    }
}