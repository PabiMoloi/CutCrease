package com.example.pmoloi.cutcrease

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pmoloi.cutcrease.model.ProductColor
import de.hdodenhof.circleimageview.CircleImageView

class ColorsAdapter(private val colorsList: ArrayList<ProductColor>):RecyclerView.Adapter<ColorsAdapter.ProductColorListViewHolder>() {

    override fun onBindViewHolder(holder: ProductColorListViewHolder, position: Int) {
        val currentColor = colorsList.get(position)
        holder.colorName.text = currentColor.colour_name
        holder.colorShade.setBackgroundColor(Color.parseColor(currentColor.hex_value))
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductColorListViewHolder {
        val colorListViewHolder: View = LayoutInflater.from(parent.context).inflate(R.layout.recycler_color_list_item,parent,false)
        return ProductColorListViewHolder((colorListViewHolder))
    }

    override fun getItemCount(): Int {
        return colorsList.size
    }

    class ProductColorListViewHolder(var view: View): RecyclerView.ViewHolder(view){
        var colorName: TextView = view.findViewById(R.id.textViewThumbColorName)
        var colorShade: CircleImageView = view.findViewById(R.id.imageViewColorThumb)
    }
}