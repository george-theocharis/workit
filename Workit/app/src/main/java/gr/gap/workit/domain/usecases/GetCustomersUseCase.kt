package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.CustomersApi
import gr.gap.workit.presentation.LoginView.CustomersViewState
import io.reactivex.Observable
import javax.inject.Inject

class GetCustomersUseCase @Inject constructor(private val customersApi: CustomersApi){

    fun getCustomers(): Observable<CustomersViewState> {
        return customersApi.getCustomers()
                .map<CustomersViewState> { CustomersViewState.Data(it) }
                .startWith(CustomersViewState.Loading)
                .onErrorReturn { CustomersViewState.Error(it) }
    }
}

