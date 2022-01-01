package com.example.mycode.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface ShopDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun create(shop: Shop)

    @Query("SELECT * FROM shops ORDER BY id ASC")
    fun readAllData(): List<Shop>
}