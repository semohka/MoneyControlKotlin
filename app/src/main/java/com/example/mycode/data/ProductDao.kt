package com.example.mycode.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ProductDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(product: Product)

    @Query("SELECT * FROM product_data ORDER BY id ASC")
    fun readAllData(): List<Product>
}