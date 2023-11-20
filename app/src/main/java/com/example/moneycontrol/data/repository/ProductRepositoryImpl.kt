package com.example.moneycontrol.data.repository

import com.example.moneycontrol.domain.models.Product
import com.example.moneycontrol.domain.repository.ProductRepository

class ProductRepositoryImpl : ProductRepository {

    override fun saveProduct(param: Product): Boolean {
        return true
    }

    override fun getProduct(): Product {
        return Product(
            id = 1,
            title = "Молоко",
            priceOfOne = 10,
            totalPrice = 20,
            count = 2,
            comment = "qwerty",
            receiptId = 1,
            categoryId = 1
        )
    }

    override fun getProductById(id: Int): Product {
        return Product(
            id = 1,
            title = "Молоко",
            priceOfOne = 10,
            totalPrice = 20,
            count = 2,
            comment = "qwerty",
            receiptId = 1,
            categoryId = 1
        )
    }
}