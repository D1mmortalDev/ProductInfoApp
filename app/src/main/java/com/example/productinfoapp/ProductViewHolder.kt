package com.example.productinfoapp

import androidx.recyclerview.widget.RecyclerView
import com.example.productinfoapp.databinding.ProductItemLayoutBinding

class ProductViewHolder(private val binding:ProductItemLayoutBinding):RecyclerView.ViewHolder(binding.root) {
    fun bind(product: Product){
        binding.txtProductName.text="Product: ${product.name} "
        binding.txtProductDesc.text="Description: ${product.description}"
    }
}