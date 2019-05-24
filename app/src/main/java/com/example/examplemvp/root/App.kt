package com.example.examplemvp.root

import android.app.Application
import com.example.examplemvp.http.ApiModule
import com.example.examplemvp.login.LoginModule

class App: Application() {

    lateinit var component: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        component = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(this))
            .loginModule(LoginModule())
            .apiModule(ApiModule())
            .build()
    }
}