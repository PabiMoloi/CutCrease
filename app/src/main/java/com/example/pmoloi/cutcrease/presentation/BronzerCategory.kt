package com.example.pmoloi.cutcrease.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pmoloi.cutcrease.R

class BronzerCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bronzer_category)
        supportActionBar!!.hide()
    }

    override fun onBackPressed() {
        this.finishAfterTransition()
    }
}
