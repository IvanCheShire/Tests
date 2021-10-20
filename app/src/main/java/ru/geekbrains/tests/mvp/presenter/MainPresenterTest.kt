package ru.geekbrains.tests.mvp.presenter

import com.nhaarman.mockito_kotlin.times
import com.nhaarman.mockito_kotlin.verify
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations
import ru.geekbrains.tests.mvp.model.User
import ru.geekbrains.tests.mvp.view.MainView

class MainPresenterTest {

    private lateinit var presenter: MainPresenter

    @Mock
    lateinit var mainViewState: MainView

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        presenter = MainPresenter()
        presenter.attachView(mainViewState)
    }
    @Test
    fun saveButtonClicked_EmailIsInvalid() {
        presenter.saveButtonClicked(false, "vasya@vasyaru", "vasya@vasya.ru", "Vasya")
        verify(mainViewState, times(1)).viewInvalidEmail()
    }
    @Test
    fun saveButtonClicked_EmailsNotEqual(){
        presenter.saveButtonClicked(true, "vasya@vasya.ru", "vasya@vasya.com", "Vasya")
        verify(mainViewState, times(1)).viewEmailsNotEqual()
    }
    @Test
    fun saveButtonClicked_AllOk(){
        presenter.saveButtonClicked(true, "vasya@vasya.ru", "vasya@vasya.ru", "Vasya")
        verify(mainViewState, times(1)).viewOk(presenter.user)
    }
    @Test
    fun saveButtonClicked_AllOk_UserNotNull(){
        presenter.saveButtonClicked(true, "vasya@vasya.ru", "vasya@vasya.ru", "Vasya")
        Assert.assertNotNull(presenter.user)
    }
    @Test
    fun saveButtonClicked_AllOk_UserIsRegistated(){
        presenter.saveButtonClicked(true, "vasya@vasya.ru", "vasya@vasya.ru", "Vasya")
        Assert.assertNotNull(presenter.user)
        Assert.assertTrue(presenter.user!!.isRegistrated)
    }

}