package com.example.mycode.data


class ProductRepository(private val productDao: ProductDao) {
    val readAllData: List<Product> = productDao.readAllData()

    suspend fun add(product: Product) {
        productDao.create(product)
    }
}