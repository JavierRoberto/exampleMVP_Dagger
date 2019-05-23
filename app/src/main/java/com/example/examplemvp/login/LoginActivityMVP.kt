package com.example.examplemvp.login

interface LoginActivityMVP {

    interface View {
        fun getUser(): String
        fun getPassword(): String
        fun showUserNotAvailable()
        fun showInputError()
        fun showUserSavedMessage()
        fun setUser(user: String)
        fun setPassword(password: String)
    }

    interface Presenter {
        fun setView(view: View)
        fun loginButtonClicked()
        fun getCurrentUser()
    }

    interface Model{
        fun createUser(user: String, password: String)
        fun getUser(): User?
    }
}