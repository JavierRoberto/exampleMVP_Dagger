package com.example.examplemvp.login

interface LoginRepository {

    fun getUser(): User
    fun saveUser(user: User)
}