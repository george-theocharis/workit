package gr.gap.workit.presentation.LoginView

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.text.InputType
import android.widget.EditText
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.RxView
import gr.gap.workit.R
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

        textView.setOnClickListener{showForgotPasswordDialog()}

        btn_login.setOnClickListener { navigateToHome()}
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

    override fun loginIntent(): Observable<String> = RxView.clicks(btn_login).flatMap{ _ -> Observable.just(inputEmail.text.toString())}

    override fun render(state: LoginViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}
