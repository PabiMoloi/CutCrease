package com.example.pmoloi.cutcrease.repository.impl

import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.network.RetrofitService
import com.example.pmoloi.cutcrease.repository.IProductsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsRepositoryImpl(private var retrofitService: RetrofitService) : IProductsRepository {

    override fun getMakeupByProduct(productType: String,successHandler: (List<Product>?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        run {
            retrofitService.getMakeUpByProduct(productType).enqueue(object : Callback<List<Product>> {
                override fun onResponse(call: Call<List<Product>>?, response: Response<List<Product>>?) {
                    response?.body()?.let {
                        successHandler(it.toList())
                    }
                }
                override fun onFailure(call: Call<List<Product>>?, t: Throwable?) {
                    failureHandler(t)
                }
            })
        }
    }

    override fun getProductById(id: String, successHandler: (Product?) -> Unit, failureHandler: (Throwable?) -> Unit) {
        run{
            retrofitService.getProductById(id).enqueue(object: Callback<Product>{
                override fun onResponse(call: Call<Product>, response: Response<Product>) {
                    response.body().let(successHandler)
                }
                override fun onFailure(call: Call<Product>, t: Throwable) {
                    failureHandler(t)
                }
            })
        }
    }
}