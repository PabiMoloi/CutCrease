package com.example.pmoloi.cutcrease.util

import android.content.Context
import com.example.pmoloi.cutcrease.network.RetrofitService
import com.example.pmoloi.cutcrease.network.RetrofitUtility
import com.example.pmoloi.cutcrease.repository.IProductsRepository
import com.example.pmoloi.cutcrease.repository.impl.ProductsRepositoryImpl

class RepositoryInjectorUtil {
    companion object {
        private var iProductRepository: IProductsRepository? = null
        var retrofitService: RetrofitService = RetrofitUtility.getRetrofitService()

        fun getInstance(context: Context): IProductsRepository {
            if (iProductRepository == null) {
                synchronized(IProductsRepository::class.java) {
                    if (iProductRepository == null) {
                        iProductRepository = ProductsRepositoryImpl(retrofitService)
                    }
                }
            }
            return iProductRepository!!
        }
    }
}