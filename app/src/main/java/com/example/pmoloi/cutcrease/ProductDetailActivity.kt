package com.example.pmoloi.cutcrease

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.model.ProductColor
import com.squareup.picasso.Picasso


class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        supportActionBar?.hide()
        val extras = intent.extras
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewProductColors)
        val adapter = ColorsAdapter(extras?.getStringArrayList("colors") as ArrayList<ProductColor>)

        val productName: TextView = findViewById(R.id.textViewProductName)
        val brand: TextView = findViewById(R.id.textViewBrandName)
        val productPrice: TextView = findViewById(R.id.textViewPrice)
        val productRating: TextView = findViewById(R.id.textViewRating)
        val productDescription: TextView = findViewById(R.id.textViewDescription)
        val productImage:ImageView = findViewById(R.id.imageViewProductThumb)
        Picasso.get().load(extras.getString("image")).into(productImage)
        brand.text = extras.getString("brandName")
        productName.text = extras.getString("productName")
        productPrice.text = extras.getString("price")
        productDescription.text = extras.getString("description")
        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        recyclerView.adapter = adapter
    }
}
