package com.example.examplemvp

interface LoginRepository {

    fun getUser(): User
    fun saveUser(user: User)
}