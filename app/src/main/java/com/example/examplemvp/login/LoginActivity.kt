package com.example.examplemvp.login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.examplemvp.R
import com.example.examplemvp.http.TwitchAPI
import com.example.examplemvp.http.apimodel.JsonRoot
import com.example.examplemvp.root.App
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class LoginActivity : AppCompatActivity(), LoginActivityMVP.View {

    @Inject
    lateinit var presenter: LoginActivityMVP.Presenter

    @Inject
    lateinit var twitchAPI: TwitchAPI


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonSend.setOnClickListener {
            presenter.loginButtonClicked()
        }

        (application as App).component.inject(this)

        val call = twitchAPI.getRoot()
        call.enqueue(object: Callback<JsonRoot> {
            override fun onResponse(call: Call<JsonRoot>, response: Response<JsonRoot>) {
                if (response.code() == 200) {
                    val jsonRoot = response.body()
                    val lista = jsonRoot!!.data
                    for (value in lista) {
                        Log.d("TAG", ""+value.language)
                    }
                }
            }

            override fun onFailure(call: Call<JsonRoot>, t: Throwable) {
                print("error!!!")
            }

        })

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
