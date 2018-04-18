import gr.gap.workit.data.network.CustomersApi
import gr.gap.workit.domain.model.Customer
import gr.gap.workit.presentation.AddCustomerView.AddCustomerViewState
import io.reactivex.Observable
import javax.inject.Inject

class AddCustomerUseCase @Inject constructor(private val customersApi: CustomersApi){

    fun add(customer: Customer): Observable<AddCustomerViewState> {
        return customersApi.addCustomer(customer)
                .map<AddCustomerViewState> { AddCustomerViewState.Data }
                .startWith(AddCustomerViewState.Loading)
                .onErrorReturn { AddCustomerViewState.Error(it) }
    }
}

