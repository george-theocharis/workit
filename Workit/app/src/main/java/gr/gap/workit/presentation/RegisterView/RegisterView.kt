package gr.gap.workit.presentation.RegisterView


import com.hannesdorfmann.mosby3.mvp.MvpView
import gr.gap.workit.domain.model.User
import io.reactivex.Observable

/**
 * Created by developer1 on 26/03/2018.
 */
interface RegisterView : MvpView {
    fun registerIntent() : Observable<User>
    fun render(state: RegisterViewState)
}