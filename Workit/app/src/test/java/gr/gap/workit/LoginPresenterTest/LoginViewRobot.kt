package gr.gap.workit.LoginPresenterTest

import gr.gap.workit.presentation.LoginView.LoginPresenter
import gr.gap.workit.presentation.LoginView.LoginView
import gr.gap.workit.presentation.LoginView.LoginViewState
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import io.reactivex.subjects.ReplaySubject
import org.junit.Assert
import java.util.concurrent.CopyOnWriteArrayList
import java.util.concurrent.TimeUnit

class LoginViewRobot constructor(loginPresenter: LoginPresenter) : LoginView {

    private val renderEvents = CopyOnWriteArrayList<LoginViewState>()
    private val renderEventSubject = ReplaySubject.create<LoginViewState>()
    private val loginSubject: PublishSubject<String> = PublishSubject.create()

    init {
        loginPresenter?.attachView(this)
    }

    fun fireLoginIntent(credentials: String) = loginSubject.onNext(credentials)

    override fun loginIntent(): Observable<String> =
            loginSubject


    override fun render(state: LoginViewState) {
        renderEvents.add(state)
        renderEventSubject.onNext(state)
    }

    fun assertExpectedViewStates(count: Long, vararg expectedStates: LoginViewState)
    {
        renderEventSubject.take(count)
                .timeout(10, TimeUnit.SECONDS)
                .blockingSubscribe()

        Assert.assertEquals(expectedStates.asList(), renderEvents)
    }
}