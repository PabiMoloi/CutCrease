package com.example.pmoloi.cutcrease

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.viewmodel.ProductViewModel

class ProductsListViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list_view)
        supportActionBar?.hide()

        setupToolbar()
       setupRecyclerView()
        val productListViewModel = ProductViewModel(Application())
        val adapter = ProductListAdapter(productListViewModel)
        val progressBar:ProgressBar = findViewById(R.id.progressBarProductList)
        productListViewModel.response.observe(this, Observer<List<Product>> {
            it.let { adapter.notifyDataSetChanged()
                progressBar.visibility = View.GONE}
        })
        productListViewModel.getMakeUpByProduct(intent.getStringExtra("category"))

        recyclerView.adapter = adapter

    }

    private fun setupRecyclerView(){
        recyclerView = findViewById(R.id.recyclerViewProductList)
        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
    }

    private fun setupToolbar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbarProductList)
        toolbar.title = intent.getStringExtra("category").capitalize()
    }
}
