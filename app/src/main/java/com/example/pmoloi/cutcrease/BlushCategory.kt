package com.example.pmoloi.cutcrease

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class BlushCategory : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blush_category)
        supportActionBar!!.hide()
    }

    override fun onBackPressed() {
        this.finishAfterTransition()
    }
}
