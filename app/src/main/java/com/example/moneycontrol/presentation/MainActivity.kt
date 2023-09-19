package com.example.moneycontrol.presentation

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.moneycontrol.R
import com.example.moneycontrol.data.repository.ProductRepositoryImpl
import com.example.moneycontrol.databinding.ActivityMainBinding
import com.example.moneycontrol.domain.usecase.GetProductListUseCase
import com.example.moneycontrol.domain.usecase.SaveProductUseCase


class MainActivity : AppCompatActivity() {

    private val productRepository = ProductRepositoryImpl()
    private val getProductListUseCase = GetProductListUseCase(productRepository = productRepository)
    private val saveProductUseCase = SaveProductUseCase(productRepository = productRepository)

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val saveProduct = findViewById<Button>(R.id.saveProduct)

        saveProduct.setOnClickListener {
            val textProduct = binding.product.text.toString()
            val textPrice = binding.price.text.toString()
//            val params = Product(title = textProduct, price = textPrice)
//            val result: Boolean = saveProductUseCase.execute(param = params)
            binding.productList.text = "$textProduct $textPrice"
            val productName = getProductListUseCase.execute()
//            productList.text = "${productName.title} ${productName.price}"
        }

    }

}