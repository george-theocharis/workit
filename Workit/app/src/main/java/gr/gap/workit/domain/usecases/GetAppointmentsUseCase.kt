package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.CustomersApi
import gr.gap.workit.presentation.AppointmentsView.AppointmentsViewState
import io.reactivex.Observable
import javax.inject.Inject

class GetAppointmentsUseCase  @Inject constructor(private val customersApi: CustomersApi) {

    fun getAppointments(id: Int): Observable<AppointmentsViewState> =
            customersApi.getAppoinmentsOfCustomer(id)
                    .map<AppointmentsViewState> { AppointmentsViewState.Data(it)}
                    .startWith(AppointmentsViewState.Loading)
                    .onErrorReturn { AppointmentsViewState.Error(it)}
}