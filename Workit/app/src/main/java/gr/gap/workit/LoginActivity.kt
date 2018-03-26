package gr.gap.workit

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.app.AppCompatActivity
import android.text.InputType
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

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
}
