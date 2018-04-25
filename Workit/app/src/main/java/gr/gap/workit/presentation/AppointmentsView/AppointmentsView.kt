package gr.gap.workit.presentation.AppointmentsView

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface AppointmentsView : MvpView {

    fun loadAppointmentsIntent() : Observable<Int>
    fun render(state: AppointmentsViewState)
}