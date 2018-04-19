package gr.gap.workit.data.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import gr.gap.workit.presentation.AddCustomerView.AddCustomerPresenter
import gr.gap.workit.presentation.CustomerDetailsView.CustomerDetailsPresenter
import gr.gap.workit.presentation.LoginView.CustomersPresenter
import gr.gap.workit.presentation.LoginView.LoginPresenter
import gr.gap.workit.presentation.RegisterView.RegisterPresenter
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    fun loginPresenter(): LoginPresenter
    fun registerPresenter(): RegisterPresenter
    fun customersPresenter(): CustomersPresenter
    fun addCustomerPresenter(): AddCustomerPresenter
    fun customerDetailsPresenter(): CustomerDetailsPresenter
}