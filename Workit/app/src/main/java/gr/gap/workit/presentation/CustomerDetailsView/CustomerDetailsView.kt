package gr.gap.workit.presentation.CustomerDetailsView

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface CustomerDetailsView : MvpView {

    fun loadCustomerDetailsIntent(): Observable<Boolean>
    fun render(state: CustomerDetailsViewState)
}