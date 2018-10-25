package com.example.pmoloi.cutcrease.viewmodel

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pmoloi.cutcrease.RepositoryInjectorUtil
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.repository.IProductsRepository

class ProductViewModel(private val application: Application): ViewModel() {

    private lateinit var productRepository: IProductsRepository
    private var response: LiveData<List<Product>> = MutableLiveData()

    fun getMakeUpByProduct(productType: String): LiveData<List<Product>> {
        productRepository = RepositoryInjectorUtil.getInstance(application)
        response = productRepository.getMakeupByProduct(productType)
        return response
    }
}