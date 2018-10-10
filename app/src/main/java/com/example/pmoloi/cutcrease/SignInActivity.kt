package com.example.pmoloi.cutcrease

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar

class SignInActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        val toolbar = findViewById<android.support.v7.widget.Toolbar>(R.id.toolbar)
        toolbar?.title = "Sign In"
        toolbar.setNavigationIcon(R.drawable.ic_arrow_back24dp)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
