package com.example.pmoloi.cutcrease

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class SignUpActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)
        setSupportActionBar(findViewById(R.id.toolbarSignUp))
    }
}