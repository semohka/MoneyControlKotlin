package com.example.moneycontrol.domain.repository

import com.example.moneycontrol.domain.models.Product

interface ProductRepository {

    fun saveProduct(saveParam: Product): Boolean

    fun getProduct(): Product
}