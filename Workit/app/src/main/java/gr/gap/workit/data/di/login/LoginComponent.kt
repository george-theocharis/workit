package gr.gap.workit.data.di.login

import dagger.Component
import gr.gap.workit.data.di.app.AppComponent
import gr.gap.workit.presentation.LoginView.LoginPresenter

@Component(modules = [(LoginModule::class)], dependencies = [(AppComponent::class)])
interface LoginComponent {
    fun presenter(): LoginPresenter
}