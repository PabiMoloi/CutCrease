package com.example.pmoloi.cutcrease.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.google.gson.GsonBuilder
import com.google.gson.Gson



class RetrofitClient {
    companion object {

        var gson = GsonBuilder()
                .setLenient()
                .create()

        var client: Retrofit? = null
        fun getClient(baseURL: String): Retrofit {
            if (client == null) {
                client = Retrofit.Builder()
                        .baseUrl(baseURL)
                        .addConverterFactory(GsonConverterFactory.create(gson))
                        .build()
            }
            return client!!
        }
    }
}