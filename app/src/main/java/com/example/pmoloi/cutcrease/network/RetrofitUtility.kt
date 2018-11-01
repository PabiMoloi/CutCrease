package com.example.pmoloi.cutcrease.network

class RetrofitUtility {
    companion object {
        val BASE_URL = "https://makeup-api.herokuapp.com/api/v1/"
        fun getRetrofitService(): RetrofitService {
            return RetrofitClient.getClient(BASE_URL).create(RetrofitService::class.java)
        }
    }
}