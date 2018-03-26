package gr.gap.workit.presentation.LoginView

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.view.View
import android.widget.EditText
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.RxView
import gr.gap.workit.R
import gr.gap.workit.domain.model.LoginCredentials
import gr.gap.workit.domain.model.User
import gr.gap.workit.presentation.HomeView.HomeActivity
import gr.gap.workit.presentation.RegisterView.RegisterActivity
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : MviActivity<LoginView, LoginPresenter>(), LoginView {

    override fun createPresenter(): LoginPresenter = LoginPresenter()

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
            editTextMail?.hint= getString(R.string.email)
            editTextMail?.inputType = InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
            setPositiveButton(R.string.send){
                dialog, _ -> dialog.dismiss()
            }
        }

        val dialog = dialogBuilder.create()
        dialog.setView(editTextMail)
        dialog.show()
    }

    override fun loginIntent(): Observable<LoginCredentials> = RxView.clicks(btn_login).flatMap{ _ ->
        Observable.just(
                LoginCredentials(inputEmail.text.toString(), inputPassword.text.toString()
        ))}

    override fun render(state: LoginViewState) {
        when(state) {
            is LoginViewState.Loading -> renderLoading()
            is LoginViewState.Data -> renderLogin(state)
            is LoginViewState.Error -> renderError(state)
        }
    }

    private fun renderLoading(){
        layoutEmail.visibility = View.GONE
    }

    private fun renderLogin(state: LoginViewState){
        layoutEmail.visibility = View.VISIBLE
        navigateToHome()
    }

    private fun renderError(state: LoginViewState){
        layoutEmail.visibility = View.VISIBLE
        textLogo.text = "Error!"
    }
}
