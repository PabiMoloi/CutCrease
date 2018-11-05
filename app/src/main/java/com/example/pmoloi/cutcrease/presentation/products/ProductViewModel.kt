package com.example.pmoloi.cutcrease.presentation.products

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.pmoloi.cutcrease.util.RepositoryInjectorUtil
import com.example.pmoloi.cutcrease.model.Product
import com.example.pmoloi.cutcrease.repository.IProductsRepository

class ProductViewModel(private val application: Application): ViewModel() {

    private lateinit var productRepository: IProductsRepository
    var response: MutableLiveData<List<Product>> = MutableLiveData()
    var error = MutableLiveData<Throwable>()

    fun getMakeUpByProduct(productType: String): LiveData<List<Product>> {
        productRepository = RepositoryInjectorUtil.getInstance(application)
        productRepository.getMakeupByProduct(
           productType,
               {
                   response.value = it
               },
               {
                   error.value = it
               }
               )
        return response
    }

    fun getProductListSize(): Int? {
        response.value?.let {
            return it.size
        }
        return 0
    }

    fun getProductAtPosition(position: Int): Product? {
        return response.value?.get(position)
    }
}