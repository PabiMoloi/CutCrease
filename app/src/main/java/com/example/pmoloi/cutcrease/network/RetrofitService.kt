package com.example.pmoloi.cutcrease.network

import com.example.pmoloi.cutcrease.model.Product
import retrofit2.Call
import retrofit2.Callback
import retrofit2.http.GET
import retrofit2.http.Query

interface RetrofitService {
    @GET("product_type=")
    fun getMakeUpByProduct(@Query("product_type")product_type:String): Call<List<Product>>
}