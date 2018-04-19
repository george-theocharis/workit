package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.CustomersApi
import gr.gap.workit.presentation.CustomerDetailsView.CustomerDetailsViewState
import io.reactivex.Observable
import javax.inject.Inject

class GetCustomerDetailsUseCase @Inject constructor(private val customersApi: CustomersApi){

    fun getCustomers(): Observable<CustomerDetailsViewState> {
        return customersApi.getCustomer(1)
                .map<CustomerDetailsViewState> { CustomerDetailsViewState.Data(it) }
                .startWith(CustomerDetailsViewState.Loading)
                .onErrorReturn { CustomerDetailsViewState.Error(it) }
    }
}
