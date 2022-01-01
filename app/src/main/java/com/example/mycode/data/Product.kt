package com.example.mycode.data

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "product_data")
data class Product(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String,
    val price: Int,
    val weight: Int,
    val shop: String
)

