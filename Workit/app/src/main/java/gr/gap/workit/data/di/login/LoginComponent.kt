package gr.gap.workit.data.di.login

import dagger.Component
import gr.gap.workit.data.di.app.AppComponent
import gr.gap.workit.presentation.LoginView.LoginPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [(LoginModule::class)])
interface LoginComponent {
    fun presenter(): LoginPresenter
}