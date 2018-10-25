package com.example.pmoloi.cutcrease.repository

import androidx.lifecycle.LiveData
import com.example.pmoloi.cutcrease.model.Product

interface IProductsRepository{
    fun getMakeupByProduct(productType: String): LiveData<List<Product>>
}