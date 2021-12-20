package com.example.mycode

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import com.example.mycode.databinding.ActivityAddBinding


class AddActivity : AppCompatActivity() {

    lateinit var bindingClass: ActivityAddBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingClass = ActivityAddBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val message = intent.getStringExtra("key")
        bindingClass.tvMess.text = message
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        return true
    }

    fun onClickBack(view: View){

        intent.putExtra("key2", bindingClass.product.text.toString())
        setResult(RESULT_OK, intent)
        finish()
    }
}