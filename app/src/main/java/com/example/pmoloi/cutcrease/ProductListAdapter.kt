package com.example.pmoloi.cutcrease

import android.app.ActionBar
import android.app.Application
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.constraintlayout.widget.Constraints
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.viewmodel.ProductViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.recycler_product_list_item.view.*

class ProductListAdapter(private val productViewModel: ProductViewModel): RecyclerView.Adapter<ProductListAdapter.ProductListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductListViewHolder {
        val productListView: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_product_list_item,parent,false)
        return ProductListViewHolder(productListView)
    }

    override fun onBindViewHolder(holder: ProductListViewHolder, position: Int) {
        val currentProduct: Product? = productViewModel.getProductAtPosition(position)
        holder.productName.text = currentProduct?.name
        holder.brandName.text = currentProduct?.brand
        /*holder.priceCurrency.text = currentProduct?.price_sign.toString()
        holder.productPrice.text = currentProduct?.price
        holder.starRating.text = currentProduct?.rating.toString()
        holder.productTags.text = currentProduct?.tag_list.toString()
        holder.productDescription.text = currentProduct?.description*/
        Picasso.get().load(currentProduct?.image_link).into(holder.productThumb)

        val bundle = Bundle()
        bundle.putString("productName", currentProduct?.name)
        bundle.putString("brandName", currentProduct?.brand)
        bundle.putString("currency", currentProduct?.price_sign.toString())
        bundle.putString("price", currentProduct?.price)
        bundle.putString("rating", currentProduct?.rating.toString())
        bundle.putString("description", currentProduct?.description)
        bundle.putString("image", currentProduct?.image_link)

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
        /*var productPrice: TextView = view.findViewById(R.id.textViewPrice)
        var priceCurrency: TextView = view.findViewById(R.id.textViewCurrencySign)
        var starRating:TextView = view.findViewById(R.id.textViewRatingValue)
        var productDescription: TextView = view.findViewById(R.id.textViewProductDescription)
        var productTags: TextView = view.findViewById(R.id.textViewTagsValue)*/
    }

    override fun getItemCount(): Int {
        return productViewModel.getProductListSize()!!
    }
}