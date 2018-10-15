package com.example.pmoloi.cutcrease

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val fragmentAdapter = PagerAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)
    }

    fun onBlushClick(view: View)
    {
        val imageViewBlush : ImageView = findViewById(R.id.imageViewBlush)
        val intent = Intent(this, BlushCategory::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(this, imageViewBlush, "image_transition")
        startActivity(intent, options.toBundle())
    }

    fun onBronzerClick(view: View)
    {
        val imageViewBronzer : ImageView = findViewById(R.id.imageViewBronzer)
        val intent = Intent(this, BronzerCategory::class.java)
        val options = ActivityOptions.makeSceneTransitionAnimation(this, imageViewBronzer, "bronzer_image")
        startActivity(intent, options.toBundle())
    }
}
