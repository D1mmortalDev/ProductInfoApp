package com.example.productinfoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.productinfoapp.databinding.ActivityMainBinding
import com.example.productinfoapp.databinding.ActivityProductListBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnViewAllProd.setOnClickListener {
            val intent = Intent(this,ProductList::class.java)
            startActivity(intent)
//            finish()


        }
        binding.btnAddProd.setOnClickListener {
            val intent = Intent(this,ProductModule::class.java)
            startActivity(intent)
//            finish()

        }

    }
}