package com.example.pmoloi.cutcrease.presentation

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.pmoloi.cutcrease.R

class SignInActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var usernameTextField: EditText
    private lateinit var passwordTextField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setSupportActionBar(findViewById(R.id.toolbarSignUp))
    }

    fun onSignInClick(view: View){
        progressBar = findViewById(R.id.progressBar2)
        usernameTextField = findViewById(R.id.editTextSignInUsername)
        passwordTextField = findViewById(R.id.editTextSignInPassword)
        progressBar.visibility = View.VISIBLE
        usernameTextField.isEnabled = false
        passwordTextField.isEnabled = false
        view.isEnabled = false
        val intent = Intent(view.context, MainActivity::class.java)
        view.context.startActivity(intent)
        progressBar.visibility = View.GONE
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out)
    }
}
