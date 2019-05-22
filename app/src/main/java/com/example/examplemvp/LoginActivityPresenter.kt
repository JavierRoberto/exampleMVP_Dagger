package com.example.examplemvp

import javax.inject.Inject


class LoginActivityPresenter(model: LoginActivityMVP.Model) : LoginActivityMVP.Presenter {

    var myView: LoginActivityMVP.View? = null
    var model: LoginActivityMVP.Model

    init {
        this.model = model
    }

    override fun setView(view: LoginActivityMVP.View) {
        myView = view
    }

    override fun loginButtonClicked() {
        myView?.let {
            if (it.getUser().trim().equals("") || it.getPassword().trim().equals("")) {
                it.showInputError()
            } else {
                model.createUser(it.getUser(), it.getPassword())
                it.showUserSavedMessage()
            }
        }
    }

    override fun getCurrentUser() {
        val user = model.getUser()
        if (user == null) {
            myView?.let {
                it.showUserNotAvailable() }
        } else {
            myView?.let {
                it.setUser(user.userName)
                it.setPassword(user.password)
            }
        }


    }
}