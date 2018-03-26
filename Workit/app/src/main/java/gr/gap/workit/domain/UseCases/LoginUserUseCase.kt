package gr.gap.workit.domain.UseCases

import gr.gap.workit.domain.model.LoginCredentials
import gr.gap.workit.domain.model.User
import gr.gap.workit.presentation.LoginView.LoginView
import gr.gap.workit.presentation.LoginView.LoginViewState
import io.reactivex.Observable

/**
 * Created by developer1 on 26/03/2018.
 */
class LoginUserUseCase {

    fun loginUser(credentials: LoginCredentials): Observable<LoginViewState> {
        return Observable.just(true)
                .map<LoginViewState> { LoginViewState.Data(User(1)) }
                .startWith(LoginViewState.Loading)
                .onErrorReturn { LoginViewState.Error(it) }
    }
}