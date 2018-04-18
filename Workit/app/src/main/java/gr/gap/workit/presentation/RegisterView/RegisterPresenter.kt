package gr.gap.workit.presentation.RegisterView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.usecases.RegisterUserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class RegisterPresenter @Inject constructor(private val registerUserUseCase: RegisterUserUseCase)
    : MviBasePresenter<RegisterView, RegisterViewState>() {
    override fun bindIntents() {

        val registerViewStateObs = intent (RegisterView::registerIntent)
                .switchMap { registerUserUseCase.register(it)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(registerViewStateObs, RegisterView::render)
    }
}