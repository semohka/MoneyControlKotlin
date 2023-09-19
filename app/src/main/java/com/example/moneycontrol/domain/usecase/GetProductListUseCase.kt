package com.example.moneycontrol.domain.usecase

import com.example.moneycontrol.domain.models.Product
import com.example.moneycontrol.domain.repository.ProductRepository

class GetProductListUseCase(private val productRepository: ProductRepository) {

    fun execute(): Product {
        return productRepository.getProduct()
    }

}