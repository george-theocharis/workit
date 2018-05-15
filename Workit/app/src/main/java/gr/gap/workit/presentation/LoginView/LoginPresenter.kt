package gr.gap.workit.presentation.LoginView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.usecases.LoginUserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by developer1 on 26/03/2018.
 */
class LoginPresenter @Inject constructor(private val loginUserUseCase: LoginUserUseCase) : MviBasePresenter<LoginView, LoginViewState>() {
    override fun bindIntents() {

        val loginViewState = intent (LoginView::loginIntent)
                .switchMap { loginUserUseCase.loginUser(it.first, it.second)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(loginViewState, LoginView::render)
    }
}