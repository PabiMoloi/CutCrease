package com.example.pmoloi.cutcrease.presentation.signUp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.pmoloi.cutcrease.R

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSupportActionBar(findViewById(R.id.toolbarSignUp))
    }
}
