package team.gap.workit.views.Login

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.hannesdorfmann.mosby3.mvi.MviActivity
import io.reactivex.Observable
import team.gap.workit.R

class LoginActivity : MviActivity<LoginView, LoginPresenter>(), LoginView  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun createPresenter(): LoginPresenter {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun loginIntent(): Observable<Unit> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun render(state: LoginViewState) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
