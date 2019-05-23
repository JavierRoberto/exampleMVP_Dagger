package com.example.examplemvp.login

class MemoryRepository: LoginRepository {

    private var user: User = User("Fox", "1234")


    override fun getUser(): User {
        return user
    }

    override fun saveUser(user: User) {
        this.user = user
    }
}