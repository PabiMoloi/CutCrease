package com.example.pmoloi.cutcrease.presentation.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.pmoloi.cutcrease.presentation.product.ProductFragment
import com.example.pmoloi.cutcrease.presentation.brands.BrandsFragment

class PagerAdapter(fragmentManager: FragmentManager): FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                ProductFragment()
            }
            else -> {
                BrandsFragment()
            }
        }
    }
    override fun getCount(): Int {
        return 2
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position){
            0 -> "Products"
            else -> "Brands"
        }
    }
}