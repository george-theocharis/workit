package gr.gap.workit.presentation.LoginView

import gr.gap.workit.domain.model.User

/**
 * Created by developer1 on 26/03/2018.
 */
sealed class LoginViewState {
    object Loading : LoginViewState()
    data class Data(val user: User) : LoginViewState()
    data class Error(val error: Throwable) : LoginViewState()
}