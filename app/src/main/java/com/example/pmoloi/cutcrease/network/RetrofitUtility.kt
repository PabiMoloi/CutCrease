package com.example.pmoloi.cutcrease.network

class RetrofitUtility {
    companion object {
        val BASE_URL = "http://makeup-api.herokuapp.com/api/v1/products?"
        fun getRetrofitService(): RetrofitService {
            return RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
        }
    }
}