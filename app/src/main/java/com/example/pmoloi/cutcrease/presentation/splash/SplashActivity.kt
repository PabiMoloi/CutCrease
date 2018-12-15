package com.example.pmoloi.cutcrease.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.pmoloi.cutcrease.R

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    fun startSignInActivity(view: View){
        val intent = Intent(view.context, SignInActivity::class.java)
        view.context.startActivity(intent)
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down)
    }
    fun startSignUpActivity(view: View)
    {
        val intent = Intent(view.context, SignUpActivity::class.java)
        view.context.startActivity(intent)
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down)
    }
}
