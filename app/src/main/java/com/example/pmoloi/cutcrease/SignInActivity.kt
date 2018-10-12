package com.example.pmoloi.cutcrease

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.transition.Visibility
import android.view.View
import android.widget.ProgressBar

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setSupportActionBar(findViewById(R.id.toolbarSignUp))
    }

    fun onSignInClick(view: View){
        val progressBar = findViewById<ProgressBar>(R.id.progressBar2)
        progressBar.visibility = View.VISIBLE
        view.isEnabled = false
    }
}
