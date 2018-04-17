package gr.gap.workit.presentation.LoginView

import gr.gap.workit.domain.model.Customer


/**
 * Created by developer1 on 26/03/2018.
 */
sealed class CustomersViewState {
    object Loading : CustomersViewState()
    data class Data(val customers: List<Customer>) : CustomersViewState()
    data class Error(val error: Throwable) : CustomersViewState()
}