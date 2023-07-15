package com.example.productinfoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.productinfoapp.databinding.ActivityProductModuleBinding

class ProductModule : AppCompatActivity() {
    private lateinit var binding: ActivityProductModuleBinding
    private lateinit var databaseHelper: DatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityProductModuleBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //database
        databaseHelper = DatabaseHelper(this)


        binding.btnAdd.setOnClickListener {
            val productName= binding.etProdName.text.toString()
            val productDesc =binding.etProdDesc.text.toString()
            addProduct(productName,productDesc)
            Toast.makeText(applicationContext,"New product added",Toast.LENGTH_SHORT).show()
        }
    }

    private fun addProduct(productName: String, productDesc: String) {
          val product = Product(0,productName,productDesc)
          databaseHelper.insertProduct(product)
    }

}