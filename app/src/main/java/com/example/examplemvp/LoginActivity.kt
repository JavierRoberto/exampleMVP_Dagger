package com.example.examplemvp

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.examplemvp.root.App
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {

    @Inject
    lateinit var presenter: LoginActivityMVP.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonSend.setOnClickListener {
            presenter.loginButtonClicked()
        }

        (application as App).component.inject(this)
    }

    override fun onResume() {
        super.onResume()
        presenter.setView(this)
    }


    override fun getUser(): String {
        return editTextUser.text.toString()
    }

    override fun getPassword(): String {
        return editTextPassword.text.toString()
    }

    override fun showUserNotAvailable() {
        Toast.makeText(this, "user not available", Toast.LENGTH_SHORT).show()
    }

    override fun showInputError() {
        Toast.makeText(this, "error in input", Toast.LENGTH_SHORT).show()
    }

    override fun showUserSavedMessage() {
        Toast.makeText(this, "User saved!", Toast.LENGTH_SHORT).show()
    }

    override fun setUser(user: String) {
        editTextUser.setText(user)
    }
    override fun setPassword(password: String) {
        editTextPassword.setText(password)
    }
}
