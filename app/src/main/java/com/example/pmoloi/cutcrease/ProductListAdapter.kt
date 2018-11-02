package com.example.pmoloi.cutcrease

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.viewmodel.ProductViewModel
import com.squareup.picasso.Picasso
import java.util.ArrayList

class ProductListAdapter(private val productViewModel: ProductViewModel): RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val productListView: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_product_list_item,parent,false)
        return ProductListViewHolder(productListView)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val currentProduct: Product? = productViewModel.getProductAtPosition(position)
        holder.productName.text = currentProduct?.name
        holder.brandName.text = currentProduct?.brand
        Picasso.get().load(currentProduct?.image_link).into(holder.productThumb)

        val bundle = Bundle()
        bundle.putString("productName", currentProduct?.name)
        bundle.putString("brandName", currentProduct?.brand)
        bundle.putString("currency", currentProduct?.price_sign.toString())
        bundle.putString("price", currentProduct?.price)
        bundle.putString("rating", currentProduct?.rating.toString())
        bundle.putString("description", currentProduct?.description)
        bundle.putString("image", currentProduct?.image_link)
        bundle.putStringArrayList("colors", currentProduct?.product_colors as ArrayList<String>)

        holder.productThumb.setOnClickListener{
            view ->
            val intent = Intent(view.context, ProductDetailActivity::class.java)
            intent.putExtras(bundle)
            view.context.startActivity(intent)
        }
    }

    class ProductListViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var productName: TextView = view.findViewById(R.id.textViewProductName)
        var brandName: TextView = view.findViewById(R.id.textViewBrandName)
        var productThumb:ImageView = view.findViewById(R.id.imageViewProductImage)
    }

    override fun getItemCount(): Int {
        return productViewModel.getProductListSize()!!
    }
}

