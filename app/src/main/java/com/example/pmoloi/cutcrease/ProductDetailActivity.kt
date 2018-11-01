package com.example.pmoloi.cutcrease

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso


class ProductDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_detail)

        supportActionBar?.hide()
        val extras = intent.extras
        val productName: TextView = findViewById(R.id.textViewProductName)
        val productPrice: TextView = findViewById(R.id.textViewPrice)
        val productRating: TextView = findViewById(R.id.textViewRating)
        val productDescription: TextView = findViewById(R.id.textViewDescription)
        val productImage:ImageView = findViewById(R.id.imageViewProductThumb)
        Picasso.get().load(extras?.getString("image")).into(productImage)
        productName.text = extras?.getString("productName")
        productPrice.text = extras?.getString("price")
        productDescription.text = extras?.getString("description")
    }
}
