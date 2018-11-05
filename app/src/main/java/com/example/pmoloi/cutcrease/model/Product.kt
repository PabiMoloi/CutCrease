package com.example.pmoloi.cutcrease.model

import com.google.gson.annotations.SerializedName

data class Product(@SerializedName("id") val id: String? = null,
                   val brand: String? = null,
                   val name: String? = null,
                   val price: String? = null,
                   val price_sign: kotlin.Any? = null,
                   val currency: kotlin.Any? = null,
                   val image_link: String? = null,
                   val product_link: String? = null,
                   val website_link: String? = null,
                   val description: String? = null,
                   val rating: Double? = null,
                   val category: String? = null,
                   val product_type: String? = null,
                   val tag_list: List<kotlin.Any>? = null,
                   val product_colors: ArrayList<ProductColor>? = null)