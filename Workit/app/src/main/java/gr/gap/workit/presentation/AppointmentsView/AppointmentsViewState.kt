package gr.gap.workit.presentation.AppointmentsView

import gr.gap.workit.domain.model.Appointment

sealed class AppointmentsViewState {
    object Loading : AppointmentsViewState()
    data class Data(val appointments: List<Appointment>) : AppointmentsViewState()
    data class Error(val throwable: Throwable) : AppointmentsViewState()
}