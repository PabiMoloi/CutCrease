package com.example.pmoloi.cutcrease

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class ProductCategoryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_category)
        supportActionBar!!.hide()
    }

    override fun onBackPressed() {
        this.finishAfterTransition()
    }
}
