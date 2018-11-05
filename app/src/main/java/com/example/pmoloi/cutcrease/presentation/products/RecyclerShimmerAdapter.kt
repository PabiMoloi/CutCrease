package com.example.pmoloi.cutcrease.presentation.products

import android.animation.ArgbEvaluator
import android.animation.ObjectAnimator
import android.animation.ValueAnimator
import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.R

class RecyclerShimmerAdapter : RecyclerView.Adapter<RecyclerShimmerAdapter.RecyclerShimmerViewHolder>() {

    override fun onBindViewHolder(holder: RecyclerShimmerViewHolder, position: Int) {

        animateObjects(holder.shimmerBrandName,"backgroundColor")
        animateObjects(holder.shimmerProductName,"backgroundColor")
        animateObjects(holder.shimmerProductThumb,"backgroundColor")
    }

    private fun animateObjects(target: Any, property: String){
        val objectAnimator = ObjectAnimator.ofObject(target,
                property,
                ArgbEvaluator(),
                Color.WHITE,
                Color.GRAY)

        objectAnimator.repeatCount = 10
        objectAnimator.repeatMode = ValueAnimator.REVERSE
        objectAnimator.duration = 1500
        objectAnimator.start()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerShimmerViewHolder {
        val shimmerListViewHolder: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_shimmer_product_list_item,parent,false)
        return RecyclerShimmerViewHolder((shimmerListViewHolder))
    }

    override fun getItemCount(): Int {
        return 10
    }

    class RecyclerShimmerViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var shimmerProductName: TextView = view.findViewById(R.id.textViewShimmerProductName)
        var shimmerBrandName: TextView = view.findViewById(R.id.textViewShimmerProductBrand)
        var shimmerProductThumb: ImageView = view.findViewById(R.id.imageViewShimmerProductThumb)
    }
}