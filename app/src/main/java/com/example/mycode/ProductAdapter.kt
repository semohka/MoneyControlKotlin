package com.example.mycode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycode.databinding.ProductItemBinding

class ProductAdapter: RecyclerView.Adapter<ProductAdapter.ProductHolder>() {
    val productList = ArrayList<Product>()

    class ProductHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ProductItemBinding.bind(item)
        fun bind(product: Product) = with(binding){
            prodImage.setImageResource(product.id)
            prodTitle.text = product.title
            prodPrice.text = product.price.toString()
            prodShop.text = product.shop
            prodWeigth.text = product.weigth.toString()

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_item, parent, false)
        return ProductHolder(view)
    }

    override fun onBindViewHolder(holder: ProductHolder, position: Int) {
        holder.bind(productList[position])
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun addProduct(product: Product){
        productList.add(product)
        notifyDataSetChanged()
    }
}