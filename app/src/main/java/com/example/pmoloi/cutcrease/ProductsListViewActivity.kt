package com.example.pmoloi.cutcrease

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.MotionEvent
import android.view.View
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import android.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.R.id.position
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.viewmodel.ProductViewModel
import kotlinx.android.synthetic.main.recycler_product_list_item.*
import kotlinx.android.synthetic.main.recycler_product_list_item.view.*

class ProductsListViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list_view)
        supportActionBar?.hide()

        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbarProductList)
        toolbar.title = intent.getStringExtra("category").capitalize()
        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewProductList)
        val productListViewModel = ProductViewModel(Application())
        val adapter = ProductListAdapter(productListViewModel)
        val progressBar:ProgressBar = findViewById(R.id.progressBarProductList)
        productListViewModel.response.observe(this, Observer<List<Product>> {
            it.let { adapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE}
        })
        productListViewModel.getMakeUpByProduct(intent.getStringExtra("category"))
        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
        recyclerView.adapter = adapter

    }
}
