package gr.gap.workit.presentation.LoginView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.usecases.LoginUserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by developer1 on 26/03/2018.
 */
class LoginPresenter : MviBasePresenter<LoginView, LoginViewState>() {
    override fun bindIntents() {

        val loginViewStateObs = intent (LoginView::loginIntent)
                .switchMap { LoginUserUseCase().loginUser(it)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(loginViewStateObs, LoginView::render)
    }
}