package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.CustomersApi
import gr.gap.workit.presentation.CustomerDetailsView.CustomerDetailsViewState
import io.reactivex.Observable
import javax.inject.Inject

class GetCustomerDetailsUseCase @Inject constructor(private val customersApi: CustomersApi){

    fun getCustomer(customerId: Int): Observable<CustomerDetailsViewState> {
        return customersApi.getCustomer(customerId)
                .map<CustomerDetailsViewState> { CustomerDetailsViewState.Data(it) }
                .startWith(CustomerDetailsViewState.Loading)
                .onErrorReturn { CustomerDetailsViewState.Error(it) }
    }
}
