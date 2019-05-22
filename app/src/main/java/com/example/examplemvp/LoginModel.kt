package com.example.examplemvp

class LoginModel(loginRepository: LoginRepository): LoginActivityMVP.Model {

    val repository: LoginRepository

    init {
        repository = loginRepository
    }

    override fun createUser(user: String, password: String) {
        repository.saveUser(User(user, password))
    }

    override fun getUser(): User? {
        return repository.getUser()
    }
}