package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.CustomersApi
import gr.gap.workit.presentation.TransactionsView.TransactionsViewState
import io.reactivex.Observable
import javax.inject.Inject

class GetTransactionsUseCase @Inject constructor(private val customersApi: CustomersApi){

    fun getTransactions(customerId: Int?): Observable<TransactionsViewState> {
        return customersApi.getCustomerTransactions(customerId)
                .map<TransactionsViewState> { TransactionsViewState.Data(it) }
                .startWith(TransactionsViewState.Loading)
                .onErrorReturn { TransactionsViewState.Error(it) }
    }
}