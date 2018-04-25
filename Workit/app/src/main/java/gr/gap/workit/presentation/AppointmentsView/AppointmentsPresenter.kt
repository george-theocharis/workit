package gr.gap.workit.presentation.AppointmentsView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.usecases.GetAppointmentsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class AppointmentsPresenter @Inject constructor(private val getAppointmentsUseCase: GetAppointmentsUseCase): MviBasePresenter<AppointmentsView, AppointmentsViewState>(){
    override fun bindIntents() {
        val allIntents = intent (AppointmentsView::loadAppointmentsIntent)
                .switchMap { getAppointmentsUseCase.getAppointments(it)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(allIntents, AppointmentsView::render)
    }

}