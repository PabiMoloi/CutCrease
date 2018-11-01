package com.example.pmoloi.cutcrease.viewmodel

import android.app.Application
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pmoloi.cutcrease.RepositoryInjectorUtil
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.repository.IProductsRepository

class ProductDetailViewModel(private val application: Application): ViewModel() {
    private lateinit var productRepository: IProductsRepository
    var response: MutableLiveData<Product> = MutableLiveData()
    var error = MutableLiveData<Throwable>()

    fun getProductById(id: String){
        productRepository = RepositoryInjectorUtil.getInstance(application)
        productRepository.getProductById(id,{
            response.value = it
        },{
            error.value = it
        })
    }
}