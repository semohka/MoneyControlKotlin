package com.example.mycode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.mycode.data.ProductDatabase
import com.example.mycode.data.ProductRepository
import com.example.mycode.data.Shop
import com.example.mycode.data.ShopRepository
import com.example.mycode.databinding.ActivityAddShopBinding


class AddActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityAddShopBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAddShopBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        bindingClass.saveShop.setOnClickListener { onClickSave() }

        supportActionBar?.setDisplayHomeAsUpEnabled(true)


//        val message = intent.getStringExtra("key")
//        bindingClass.tvMess.text = message
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        return true
    }

    fun onClickBack(view: View){


        intent.putExtra("key2", bindingClass.shop.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }

    private fun onClickSave(){
       val result = bindingClass.shop.text.toString()
            val repository = ShopRepository(ProductDatabase.getDatabase(this).shopDao())
            val shop = Shop(title = result)
            repository.add(shop)
        finish()


    }

}
