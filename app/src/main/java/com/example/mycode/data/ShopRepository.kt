package com.example.mycode.data

class ShopRepository(private val shopDao: ShopDao) {
    val readAllData: List<Shop> = shopDao.readAllData()

     fun add(shop: Shop) {
        shopDao.create(shop)
    }
}