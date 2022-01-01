package com.example.mycode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycode.data.Product
import com.example.mycode.data.ProductDatabase

import com.example.mycode.databinding.ActivityMainBinding
import java.util.*


class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    private val adapter = ProductAdapter()

    private val imageIdList = listOf(R.drawable.cans, R.drawable.detail)
    private  var index = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        ProductDatabase.getDatabase(this)

        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
//        var receipt = emptyArray<String>()
        bindingClass.bNav.selectedItemId = R.id.list
        bindingClass.bNav.setOnNavigationItemSelectedListener{
          when(it.itemId){
              R.id.list-> {
                  Toast.makeText(this, "список чеков", Toast.LENGTH_SHORT).show()
              }
              R.id.stat-> {
                  Toast.makeText(this, "статистика", Toast.LENGTH_SHORT).show()
              }
          }
            true
        }
        init()
    }

    private fun init(){
        bindingClass.apply {
            rcView.layoutManager = LinearLayoutManager(this@MainActivity)
            rcView.adapter = adapter
            buttonAdd.setOnClickListener {
                if (index > 1) index = 0
                val product = Product(imageIdList[index],"продукт", 100, 2, "вкусВилл")
                adapter.addProduct(product)
                index++

            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.sync -> {
                Toast.makeText(this, "поиск", Toast.LENGTH_SHORT).show()
            }
            R.id.set -> {
                Toast.makeText(this, "настройки", Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == 100 && resultCode == RESULT_OK && data != null){
//            bindingClass.tvRes.text = data.getStringExtra("key2")
        }
    }


    fun onClickTest1(view: View){
        val intent = Intent(this, AddActivity::class.java)
        intent.putExtra("key", "Введите новый товар")
        startActivityForResult(intent, 100)
    }

    fun onClickList(view: View){

    }
}