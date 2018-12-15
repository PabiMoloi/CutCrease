package com.example.pmoloi.cutcrease.presentation.productList

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.R
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.presentation.product.RecyclerShimmerAdapter
import com.example.pmoloi.cutcrease.viewmodel.ProductViewModel

class ProductsListViewActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var shimmerRecyclerView: RecyclerView
    private lateinit var productListViewModel: ProductViewModel
    private lateinit var recyclerAdapter: ProductListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_products_list_view)
        supportActionBar?.hide()
        setupToolbar()

        val shimmerAdapter = RecyclerShimmerAdapter()
        setupShimmerRecyclerView()
        shimmerRecyclerView.adapter = shimmerAdapter

        productListViewModel = ProductViewModel(Application())
        recyclerAdapter = ProductListAdapter(productListViewModel)

        setupRecyclerView()
        fetchProducts()
    }

    private fun setupShimmerRecyclerView(){
        shimmerRecyclerView = findViewById(R.id.recyclerViewProductList)
        shimmerRecyclerView.layoutManager = GridLayoutManager(applicationContext, 2)
    }

    private fun setupRecyclerView(){
        recyclerView = findViewById(R.id.recyclerViewProductList)
        recyclerView.layoutManager = GridLayoutManager(applicationContext,2)
    }

    private fun setupToolbar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbarProductList)
        toolbar.title = intent.getStringExtra("category").capitalize()
    }

    private fun fetchProducts(){

        productListViewModel.getMakeUpByProduct(intent.getStringExtra("category"))
        productListViewModel.response.observe(this, Observer<List<Product>> {
            it.let { recyclerAdapter.notifyDataSetChanged()
                  recyclerView.adapter = recyclerAdapter
            }
        })
    }
}
