package com.example.moneycontrol.domain.usecase

import com.example.moneycontrol.domain.models.Product
import com.example.moneycontrol.domain.repository.ProductRepository

class UpdateProductUseCase(private val productRepository: ProductRepository) {

    fun updateCount(id: Int, count: Int) {
        val product: Product = productRepository.getProductById(id)
        //присвоить обновленное количество тому продукту у которого id равен передаваемому id
        //
        product.count = count
        productRepository.saveProduct(product)
    }

}
