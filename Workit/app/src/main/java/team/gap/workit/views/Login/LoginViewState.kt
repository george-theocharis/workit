package team.gap.workit.views.Login

/**
 * Created by George Theocharis on 3/11/2018.
 */
sealed class LoginViewState {
    object Loading : LoginViewState()
    data class Data(val example: String) : LoginViewState()
    data class Error(val error: Throwable) : LoginViewState()
}