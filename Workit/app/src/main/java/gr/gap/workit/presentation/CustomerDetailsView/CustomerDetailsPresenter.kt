package gr.gap.workit.presentation.CustomerDetailsView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.usecases.GetCustomerDetailsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CustomerDetailsPresenter @Inject constructor(private val getCustomerDetailsUseCase: GetCustomerDetailsUseCase) : MviBasePresenter<CustomerDetailsView, CustomerDetailsViewState>() {
    override fun bindIntents() {

        val allIntents = intent (CustomerDetailsView::loadCustomerDetailsIntent)
                .switchMap { getCustomerDetailsUseCase.getCustomers()}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(allIntents, CustomerDetailsView::render)
    }
}