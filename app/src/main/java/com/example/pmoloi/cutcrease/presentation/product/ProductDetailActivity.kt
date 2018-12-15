package com.example.pmoloi.cutcrease.presentation

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.model.ProductColor
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.squareup.picasso.Picasso
import com.example.pmoloi.cutcrease.R
import com.google.android.material.snackbar.Snackbar



class ProductDetailActivity : AppCompatActivity() {

    private lateinit var extras: Bundle
    private lateinit var fabCart: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)
        extras = intent.extras
        supportActionBar?.hide()
        populateFields()
        setUpRecyclerView()
        fabCart = findViewById(R.id.fabCart)
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

    fun onFabCartClick(view: View){
        val mySnackbar = Snackbar.make(findViewById(R.id.CoordinatorLayoutProductDetal),"Item added to cart.", Snackbar.LENGTH_SHORT)
        mySnackbar.setAction("view cart", View.OnClickListener {  })
        mySnackbar.setActionTextColor(Color.YELLOW)
        mySnackbar.show()
    }
}
