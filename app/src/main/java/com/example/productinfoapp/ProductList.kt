package com.example.productinfoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.LayoutManager
import com.example.productinfoapp.databinding.ActivityProductListBinding

class ProductList : AppCompatActivity() {
    private lateinit var binding:ActivityProductListBinding
    private lateinit var recyclerView: RecyclerView
    private lateinit var databaseHelper: DatabaseHelper
    private lateinit var productList: MutableList<Product>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding =ActivityProductListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //database
        databaseHelper = DatabaseHelper(this)
        //recycleView
        recyclerView = binding.recyclerViewProdList
        //layout of recycleView
        recyclerView.layoutManager =LinearLayoutManager(this)

        //get product list
        productList =getAllProducts()
        recyclerView.adapter=ProductAdapter(productList)

    }
    private fun getAllProducts():MutableList<Product>{
        val allProducts =databaseHelper.getAllProducts()
        return allProducts
    }
}