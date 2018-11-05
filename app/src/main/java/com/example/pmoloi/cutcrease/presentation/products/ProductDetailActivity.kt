package com.example.pmoloi.cutcrease.presentation.products

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toolbar
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.R
import com.example.pmoloi.cutcrease.model.ProductColor
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.squareup.picasso.Picasso

class ProductDetailActivity : AppCompatActivity() {

    private lateinit var extras: Bundle
    private lateinit var toolbar: androidx.appcompat.widget.Toolbar
    private lateinit var collapsingToolbarLayout: CollapsingToolbarLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        extras = intent.extras
        toolbar = findViewById(R.id.toolbar)
        collapsingToolbarLayout = findViewById(R.id.ctl)
        setSupportActionBar(toolbar)
        supportActionBar?.title = ""
        populateFields()
        setUpRecyclerView()
        collapsingToolbarLayout.setContentScrimColor(Color.parseColor("#000000"))
    }

    private fun setUpRecyclerView(){
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewProductColors)
        val adapter = ColorsAdapter(extras.getStringArrayList("colors") as ArrayList<ProductColor>)
        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        recyclerView.adapter = adapter
    }

    private fun populateFields(){

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
        productRating.text = extras.getString("rating")
        productDescription.text = extras.getString("description")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.product_detail_menu_items, menu);
        return true;
    }
}
