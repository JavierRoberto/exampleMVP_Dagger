package com.example.examplemvp

import com.example.examplemvp.login.LoginActivityMVP
import com.example.examplemvp.login.LoginActivityPresenter
import com.example.examplemvp.login.User
import com.nhaarman.mockitokotlin2.*
import org.junit.Test

import org.junit.Before

class LoginActivityPresenterTest {

    lateinit var mockLoginModel: LoginActivityMVP.Model
    lateinit var mockLoginView: LoginActivityMVP.View
    lateinit var loginPresenter: LoginActivityMVP.Presenter
    lateinit var user: User

    @Test
    fun loadTheUserFromTheRepositoryWhenValidUserIsPresent() {
        whenever(mockLoginModel.getUser()).thenReturn(user)
        loginPresenter.getCurrentUser()
        verify(mockLoginModel, times(1)).getUser()
        verify(mockLoginView, times(1)).setUser("Fox")
        verify(mockLoginView, times(1)).setPassword("Mulder")
        verify(mockLoginView, never()).showUserNotAvailable()
    }

    @Test
    fun shouldShowErrorMessageWhenUserIsNull() {
        whenever(mockLoginModel.getUser()).thenReturn(null)
        loginPresenter.getCurrentUser()
        verify(mockLoginView, never()).setUser("Fox")
        verify(mockLoginView, never()).setPassword("Mulder")
        verify(mockLoginView, times(1)).showUserNotAvailable()
    }

    @Before
    fun setup() {
        mockLoginModel = mock()
        user = User("Fox", "Mulder")
        mockLoginView = mock()
        loginPresenter = LoginActivityPresenter(mockLoginModel)
        loginPresenter.setView(mockLoginView)
    }
}