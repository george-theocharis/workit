package gr.gap.workit.presentation.CustomerDetailsView

import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.data.di.App
import gr.gap.workit.presentation.CustomerDetailsView.CustomerDetailsViewState
import io.reactivex.Observable

class CustomerDetailsFragment : MviFragment<CustomerDetailsView, CustomerDetailsPresenter>(), CustomerDetailsView {

    override fun createPresenter(): CustomerDetailsPresenter = App.component.customerDetailsPresenter()

    override fun loadCustomerDetailsIntent(): Observable<Boolean> = Observable.just(true)

    override fun render(state: CustomerDetailsViewState) {
        when (state){
            is CustomerDetailsViewState.Loading -> renderLoading()
            is CustomerDetailsViewState.Data -> renderData()
            is CustomerDetailsViewState.Error -> renderError(state)
        }
    }

    private fun renderLoading(){

    }

    private fun renderData(){

    }

    private fun renderError(state: CustomerDetailsViewState.Error){

    }

}