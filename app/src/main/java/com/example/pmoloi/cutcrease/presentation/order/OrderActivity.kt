package com.example.pmoloi.cutcrease.presentation

import android.animation.ObjectAnimator
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmoloi.cutcrease.R
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
        supportActionBar?.hide()
        setupToolbar()
        val objectAnimator = ObjectAnimator.ofFloat(imageViewTruck, "translationX", 900f)
        objectAnimator.duration = 5000
        objectAnimator.start()
    }


    private fun setupToolbar(){
        val toolbar: androidx.appcompat.widget.Toolbar = findViewById(R.id.toolbarTrackOrder)
        toolbar.title = "Track My Order"
    }
}
