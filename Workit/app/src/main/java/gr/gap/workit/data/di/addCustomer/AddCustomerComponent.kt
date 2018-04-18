package gr.gap.workit.data.di.addCustomer

import dagger.Component
import gr.gap.workit.presentation.AddCustomerView.AddCustomerPresenter
import javax.inject.Singleton

/**
 * Created by George Theocharis on 4/18/2018.
 */
@Singleton
@Component(modules = [ AddCustomerModule::class ])
interface AddCustomerComponent {
    fun presenter(): AddCustomerPresenter
}

