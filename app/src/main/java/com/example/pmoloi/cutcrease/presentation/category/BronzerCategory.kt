package com.example.pmoloi.cutcrease.presentation.category

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pmoloi.cutcrease.R
import com.example.pmoloi.cutcrease.presentation.productList.ProductsListViewActivity

class BronzerCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bronzer_category)
        supportActionBar!!.hide()
    }

    override fun onBackPressed() {
        this.finishAfterTransition()
    }
    fun openBronzerIntent(view: View){
        val intent = Intent(this, ProductsListViewActivity::class.java)
        intent.putExtra("category", "bronzer")
        startActivity(intent)
    }
}
