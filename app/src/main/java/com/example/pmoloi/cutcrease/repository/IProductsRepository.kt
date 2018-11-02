package com.example.pmoloi.cutcrease.repository

import com.example.pmoloi.cutcrease.model.Product

interface IProductsRepository{
    fun getMakeupByProduct(productType: String,successHandler: (List<Product>?) -> Unit, failureHandler: (Throwable?) -> Unit)
}