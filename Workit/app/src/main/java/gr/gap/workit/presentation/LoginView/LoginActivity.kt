package gr.gap.workit.presentation.LoginView

import android.content.Intent
import android.os.Bundle
import android.support.transition.TransitionManager
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.RxView
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import gr.gap.workit.presentation.HomeView.HomeActivity
import gr.gap.workit.presentation.RegisterView.RegisterActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_customer_details.*
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MviActivity<LoginView, LoginPresenter>(), LoginView {

    override fun createPresenter(): LoginPresenter = App.component.loginPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        textViewRegister.setOnClickListener { navigateToRegister() }

        btn_forgotPassword.setOnClickListener{showForgotPasswordDialog()}
    }

    private fun navigateToRegister() {
        val intent = Intent(this, RegisterActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHome() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
    }

    private fun showForgotPasswordDialog() {
        val dialogBuilder = AlertDialog.Builder(this)
        lateinit var editTextMail: EditText

        with (dialogBuilder){
            setTitle(R.string.forgotPasswordTitle)
            setMessage(R.string.forgotPasswordMessage)
            editTextMail = EditText(this.context)
            editTextMail.hint= getString(R.string.email)
            editTextMail.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            setPositiveButton(R.string.send){
                dialog, _ -> dialog.dismiss()
            }
        }

        val dialog = dialogBuilder.create()
        dialog.setView(editTextMail)
        dialog.show()
    }

    override fun loginIntent(): Observable<Pair<String, String>> = RxView.clicks(btn_login)
            .map { _ ->
               Pair(inputEmail.text.toString(), inputPassword.text.toString())
            }

    override fun render(state: LoginViewState) {
        when(state) {
            is LoginViewState.Loading -> renderLoading()
            is LoginViewState.Data -> renderLogin(state)
            is LoginViewState.Error -> renderError(state)
        }
    }

    private fun renderLoading(){
        TransitionManager.beginDelayedTransition(login_content as ViewGroup)
        content.visibility = View.GONE
        loginProgressBar.visibility = View.VISIBLE
    }

    private fun renderLogin(state: LoginViewState){
        print(state.toString())
        navigateToHome()
        finish()
    }

    private fun renderError(state: LoginViewState){
        textLogo.text = (state as LoginViewState.Error).error.message
    }
}
