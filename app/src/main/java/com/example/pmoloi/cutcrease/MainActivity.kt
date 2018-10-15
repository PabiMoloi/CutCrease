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
    fun onclick(view: View)
    {
        // get the element that receives the click event
        //val imgContainerView = view.findViewById<CardView>(R.id.cardViewBlush)

// get the common element for the transition in this activity
        //val androidRobotView = view.findViewById<ImageView>(R.id.imageViewBlush)
        val androidRobotView : ImageView = findViewById(R.id.imageViewBlush)

// define a click listener
      //  imgContainerView.setOnClickListener {
            val intent = Intent(this, ProductCategoryActivity::class.java)
            // create the transition animation - the images in the layouts
            // of both activities are defined with android:transitionName="robot"
            val options = ActivityOptions
                    .makeSceneTransitionAnimation(this, androidRobotView, "image_transition")
            // start the new activity
            startActivity(intent, options.toBundle())
       // }
    }
}
