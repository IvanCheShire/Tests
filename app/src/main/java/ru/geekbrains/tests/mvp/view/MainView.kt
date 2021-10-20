package ru.geekbrains.tests.mvp.view

import moxy.MvpView
import moxy.viewstate.strategy.alias.AddToEndSingle
import ru.geekbrains.tests.mvp.model.User

@AddToEndSingle
interface MainView: MvpView {
    fun viewOk(user: User?)
    fun viewEmailsNotEqual()
    fun viewInvalidEmail()
    fun viewInvalidName()
}
