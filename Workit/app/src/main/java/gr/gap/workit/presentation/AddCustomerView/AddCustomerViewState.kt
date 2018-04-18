package gr.gap.workit.presentation.AddCustomerView

/**
 * Created by George Theocharis on 4/18/2018.
 */
sealed class AddCustomerViewState {
    object Loading : AddCustomerViewState()
    object Data : AddCustomerViewState()
    data class Error(val error: Throwable) : AddCustomerViewState()
}