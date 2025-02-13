package com.android.quickcart

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class LoginActivity : Activity() {
    private val usernameField by lazy { findViewById<EditText>(R.id.edittext_username) }
    private val passwordField by lazy { findViewById<EditText>(R.id.edittext_password) }
    private val loginButton by lazy { findViewById<Button>(R.id.btn_login) }
    private val registerText by lazy { findViewById<TextView>(R.id.text_newhere) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)

        loginButton.setOnClickListener { handleLogin() }

        registerText.setOnClickListener {
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun handleLogin() {
        val username = usernameField.text.toString().trim()
        val password = passwordField.text.toString().trim()

        if (username.isBlank() || password.isBlank()) {
            showToast("Username and Password must not be empty")
            return
        }

        if (username.equals("aliyah", ignoreCase = true) && password == "1628") {
            showToast("Successful Login")
            startActivity(Intent(this, HomeActivity::class.java))
        } else {
            showToast("Invalid Credentials")
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}