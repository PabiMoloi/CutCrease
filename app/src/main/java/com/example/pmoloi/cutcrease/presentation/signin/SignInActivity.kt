package com.example.pmoloi.cutcrease.presentation.signin

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity
import com.example.pmoloi.cutcrease.R
import com.example.pmoloi.cutcrease.presentation.main.MainActivity

class SignInActivity : AppCompatActivity() {

    private lateinit var progressBar: ProgressBar
    private lateinit var usernameTextField: EditText
    private lateinit var passwordTextField: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        setSupportActionBar(findViewById(R.id.toolbarSignUp))
        progressBar = findViewById(R.id.progressBar2)
        usernameTextField = findViewById(R.id.editTextSignInUsername)
        passwordTextField = findViewById(R.id.editTextSignInPassword)
    }

    fun onSignInClick(view: View){
        progressBar.visibility = View.VISIBLE
        usernameTextField.isEnabled = false
        passwordTextField.isEnabled = false
        view.isEnabled = false
        val intent = Intent(view.context, MainActivity::class.java)
        view.context.startActivity(intent)
        overridePendingTransition(R.anim.slide_up, R.anim.slide_down)
        Handler().postDelayed( {
            restoreViewState(view)
        }, 1000)
    }

    private fun restoreViewState(view:View){
        usernameTextField.text.clear()
        passwordTextField.text.clear()
        usernameTextField.isEnabled = true
        passwordTextField.isEnabled = true
        view.isEnabled = true
        progressBar.visibility = View.GONE
    }
}
