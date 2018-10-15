package com.example.pmoloi.cutcrease

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class BronzerCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bronzer_category)
    }

    override fun onBackPressed() {
        this.finishAfterTransition()
    }
}
