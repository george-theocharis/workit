package gr.gap.workit

/**
 * Created by developer1 on 26/03/2018.
 */
sealed class LoginViewState {
    object Loading : LoginViewState()
    data class Data(val user: User) : LoginViewState()
    data class Error(val error: Throwable) : LoginViewState()
}