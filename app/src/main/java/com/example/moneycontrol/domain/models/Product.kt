package com.example.moneycontrol.domain.models

data class Product(
    val id: Int,
    val title: String,
    val priceOfOne: Int,
    val totalPrice: Int,
    var count: Int,
    val comment: String,
    val receiptId: Int,
    val categoryId: Int,
)
