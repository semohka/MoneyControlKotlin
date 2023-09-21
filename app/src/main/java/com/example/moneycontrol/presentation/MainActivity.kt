package com.example.moneycontrol.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moneycontrol.R
import com.example.moneycontrol.data.repository.ProductRepositoryImpl
import com.example.moneycontrol.databinding.ActivityMainBinding
import com.example.moneycontrol.domain.models.Product
import com.example.moneycontrol.domain.usecase.GetProductListUseCase
import com.example.moneycontrol.domain.usecase.SaveProductUseCase


class MainActivity : AppCompatActivity() {

    private val productRepository = ProductRepositoryImpl()
    private val getProductListUseCase = GetProductListUseCase(productRepository = productRepository)
    private val saveProductUseCase = SaveProductUseCase(productRepository = productRepository)

    private lateinit var binding: ActivityMainBinding
    private lateinit var productAdapter: ProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val saveProduct = binding.saveProduct
        var arrayProductList: List<Product> = emptyList()

        val recyclerView: RecyclerView = findViewById(R.id.productList)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        productAdapter = ProductAdapter()
        recyclerView.adapter = productAdapter

        saveProduct.setOnClickListener {
            val textProduct = binding.product.text.toString()
            val textPrice = binding.price.text.toString()
            val product = Product(title = textProduct, price = textPrice.toDouble())
            arrayProductList += arrayOf(product)
            productAdapter.submitList(arrayProductList)


            binding.product.text.clear()
            binding.product.requestFocus()
            binding.price.text.clear()
        }
    }
}