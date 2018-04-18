package gr.gap.workit.presentation.AddCustomerView

import com.hannesdorfmann.mosby3.mvp.MvpView
import gr.gap.workit.domain.model.Customer
import io.reactivex.Observable

/**
 * Created by George Theocharis on 4/18/2018.
 */
interface AddCustomerView: MvpView {

    fun addCustomerIntent(): Observable<Customer>
    fun render(state: AddCustomerViewState)
}