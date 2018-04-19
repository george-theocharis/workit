package gr.gap.workit.presentation.CustomerDetailsView

import gr.gap.workit.domain.model.Customer

sealed class CustomerDetailsViewState {
    object Loading : CustomerDetailsViewState()
    data class Data(val customer: Customer) : CustomerDetailsViewState()
    data class Error(val error: Throwable) : CustomerDetailsViewState()
}