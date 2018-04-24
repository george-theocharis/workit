package gr.gap.workit.LoginPresenterTest

import android.app.Application
import gr.gap.workit.data.di.DaggerAppComponent
import gr.gap.workit.domain.model.User
import gr.gap.workit.presentation.LoginView.LoginViewState
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class LoginPresenterTest {

    @Mock
    lateinit var application: Application

    lateinit var robot: LoginViewRobot

    @Before
    fun init() {
        MockitoAnnotations.initMocks(this)
        robot = LoginViewRobot(DaggerAppComponent.builder().application(application).build().loginPresenter())
    }

    @Test
    fun shouldLoginSuccessfullyWithCorrectCredentials() {

        robot.fireLoginIntent("user1")

        robot.assertExpectedViewStates(2,
                LoginViewState.Loading,
                LoginViewState.Data(User(1, "argyrispro@gmail.com", first_name = "Argyris", last_name = "Prosilis"))

        )
    }

    @Test
    fun shouldnotlogin() {

        robot.fireLoginIntent("user1")

        robot.assertExpectedViewStates(2,
                LoginViewState.Loading,
                LoginViewState.Data(User(1, "argyrispro@gmail.com", first_name = "Argyris", last_name = "Prosilis"))

        )
    }
}