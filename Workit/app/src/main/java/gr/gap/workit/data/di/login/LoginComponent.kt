package gr.gap.workit.data.di.login

import dagger.Component
import gr.gap.workit.presentation.LoginView.LoginPresenter

@Component(modules = [(LoginModule::class)])
interface LoginComponent {
    fun presenter(): LoginPresenter
}