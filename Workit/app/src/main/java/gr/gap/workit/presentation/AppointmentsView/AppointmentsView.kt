package gr.gap.workit.presentation.AppointmentsView

import com.hannesdorfmann.mosby3.mvp.MvpView

interface AppointmentsView : MvpView {
    fun render(state: AppointmentsViewState)
}