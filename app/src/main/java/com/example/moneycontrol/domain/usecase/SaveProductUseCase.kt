package com.example.moneycontrol.domain.usecase

import com.example.moneycontrol.domain.models.Product
import com.example.moneycontrol.domain.repository.ProductRepository

class SaveProductUseCase(private val productRepository: ProductRepository) {

    fun execute(param: Product): Boolean {
        val res: Boolean = productRepository.saveProduct(saveParam = param)
        return res
    }

}