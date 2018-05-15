package gr.gap.workit.presentation.RegisterView

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.RxView
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import gr.gap.workit.domain.model.User
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : MviActivity<RegisterView, RegisterPresenter>(), RegisterView {

    override fun registerIntent(): Observable<User> = RxView.clicks(buttonRegister).flatMap { Observable.just(User(email = "user@user.com",
            first_name = "George", last_name = "George", password = "mypassword")) }

    override fun render(state: RegisterViewState) {
        when(state) {
            is RegisterViewState.Loading -> renderLoading()
            is RegisterViewState.Data -> renderData()
            is RegisterViewState.Error -> renderError(state)
        } //To change body of created functions use File | Settings | File Templates.
    }

    private fun renderError(state: RegisterViewState.Error) {
        print(state.error.message)
    }

    private fun renderData() {
    }

    private fun renderLoading() {
    }

    override fun createPresenter(): RegisterPresenter =  App.component.registerPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)
    }
}
