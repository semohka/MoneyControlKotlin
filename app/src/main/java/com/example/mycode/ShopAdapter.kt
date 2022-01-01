package com.example.mycode

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mycode.data.Shop
import com.example.mycode.databinding.ShopItemBinding

class ShopAdapter: RecyclerView.Adapter<ShopAdapter.ShopHolder>() {
    var shopList: List<Shop> = ArrayList()

    class ShopHolder(item: View): RecyclerView.ViewHolder(item) {
        val binding = ShopItemBinding.bind(item)
        fun bind(shop: Shop) = with(binding){
            shopTitle.text = shop.title

        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ShopAdapter.ShopHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.shop_item, parent, false)
        return ShopAdapter.ShopHolder(view)
    }

    override fun onBindViewHolder(holder: ShopHolder, position: Int) {
        holder.bind(shopList[position])
    }

    override fun getItemCount(): Int {
        return shopList.size
    }



}