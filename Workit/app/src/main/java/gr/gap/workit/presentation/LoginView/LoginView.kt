package gr.gap.workit.presentation.LoginView

import com.hannesdorfmann.mosby3.mvp.MvpView

/**
 * Created by developer1 on 26/03/2018.
 */
interface LoginView : MvpView {
    fun render(state: LoginViewState)
}