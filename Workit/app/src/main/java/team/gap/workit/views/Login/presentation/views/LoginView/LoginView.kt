package team.gap.workit.views.Login.presentation.views.LoginView

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

/**
 * Created by George Theocharis on 3/11/2018.
 */

interface LoginView : MvpView
{
    fun loginIntent(): Observable<Unit>

    fun render(state: LoginViewState)
}