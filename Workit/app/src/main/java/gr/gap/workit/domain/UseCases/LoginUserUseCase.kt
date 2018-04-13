package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.UserApi
import gr.gap.workit.domain.model.LoginCredentials
import gr.gap.workit.domain.model.User
import gr.gap.workit.presentation.LoginView.LoginViewState
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by developer1 on 26/03/2018.
 */
class LoginUserUseCase @Inject constructor(private val userApi: UserApi){

    fun loginUser(credentials: LoginCredentials): Observable<LoginViewState> {
        return userApi.getUser()
                .map<LoginViewState> { LoginViewState.Data(User(it.id, it.email, "John", "Pap", 1)) }
                .startWith(LoginViewState.Loading)
                .onErrorReturn { LoginViewState.Error(it) }
    }
}