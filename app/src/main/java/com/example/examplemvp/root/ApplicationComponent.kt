package com.example.examplemvp.root

import com.example.examplemvp.LoginActivity
import com.example.examplemvp.LoginModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, LoginModule::class))
interface ApplicationComponent {
    fun inject(target: LoginActivity)
}