package com.example.pmoloi.cutcrease

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    fun startSignInActivity(view: View){
        val intent = Intent(view.context, SignInActivity::class.java)
        view.context.startActivity(intent)
    }
}
