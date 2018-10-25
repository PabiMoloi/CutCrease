package com.example.pmoloi.cutcrease.repository.impl

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.network.RetrofitService
import com.example.pmoloi.cutcrease.repository.IProductsRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsRepositoryImpl(private var retrofitService: RetrofitService) : IProductsRepository {

    override fun getMakeupByProduct(productType: String): LiveData<List<Product>> {

        val responseData: MutableLiveData<List<Product>> = MutableLiveData()
        retrofitService.getMakeUpByProduct(productType).enqueue(object: Callback<List<Product>>{

            override fun onResponse(call: Call<List<Product>>, response: Response<List<Product>>) {
                responseData.value = response.body()
            }

            override fun onFailure(call: Call<List<Product>>, t: Throwable) {

            }
        })
        return responseData
    }
}