package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.UserApi
import gr.gap.workit.domain.model.User
import gr.gap.workit.presentation.RegisterView.RegisterViewState
import io.reactivex.Observable
import javax.inject.Inject

class RegisterUserUseCase @Inject constructor(private val usersApi: UserApi){

    fun register(user: User): Observable<RegisterViewState> =
            usersApi.register(user)
                    .map<RegisterViewState> { RegisterViewState.Data }
                    .startWith(RegisterViewState.Loading)
                    .onErrorReturn { RegisterViewState.Error(it) }

}
