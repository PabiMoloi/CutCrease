package com.example.pmoloi.cutcrease

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    fun startSignInActivity(view: View){
        val intent = Intent(view.context, SignInActivity::class.java)
        view.context.startActivity(intent)
        overridePendingTransition(R.anim.slide_in,R.anim.slide_out)
    }
    fun startSignUpActivity(view: View)
    {
        val intent = Intent(view.context, SignUpActivity::class.java)
        view.context.startActivity(intent)
        overridePendingTransition(R.anim.slide_in,R.anim.slide_out)
    }
}
