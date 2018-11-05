package com.example.pmoloi.cutcrease.presentation.category

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pmoloi.cutcrease.presentation.products.ProductsListViewActivity
import com.example.pmoloi.cutcrease.R

class BlushCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blush_category)
        supportActionBar!!.hide()
    }

    override fun onBackPressed() {
        this.finishAfterTransition()
    }

    fun openBlushIntent(view: View){
        val intent = Intent(this, ProductsListViewActivity::class.java)
        intent.putExtra("category", "blush")
        startActivity(intent)
    }
}
