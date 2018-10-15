package com.example.pmoloi.cutcrease.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitClient {
    companion object {

        var client: Retrofit? = null
        fun getClient(baseURL: String): Retrofit {
            if (client == null) {
                client = Retrofit.Builder().baseUrl(baseURL).addConverterFactory(GsonConverterFactory.create()).build()
            }
            return client!!
        }
    }
}