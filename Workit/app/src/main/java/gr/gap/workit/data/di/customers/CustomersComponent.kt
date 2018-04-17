package gr.gap.workit.data.di.customers

import dagger.Component
import gr.gap.workit.data.di.app.AppComponent
import gr.gap.workit.presentation.LoginView.CustomersPresenter
import javax.inject.Scope
import javax.inject.Singleton

@Singleton
@Component(modules = [(CustomersModule::class)])
interface CustomersComponent {
    fun presenter(): CustomersPresenter
}

