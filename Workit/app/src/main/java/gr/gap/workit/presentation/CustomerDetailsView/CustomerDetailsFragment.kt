package gr.gap.workit.presentation.CustomerDetailsView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import io.reactivex.Observable

class CustomerDetailsFragment : MviFragment<CustomerDetailsView, CustomerDetailsPresenter>(), CustomerDetailsView {

    override fun createPresenter(): CustomerDetailsPresenter = App.component.customerDetailsPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_customer_details,container,false)
    }

    override fun loadCustomerDetailsIntent(): Observable<Boolean> = Observable.just(true)

    override fun render(state: CustomerDetailsViewState) {
        when (state){
            is CustomerDetailsViewState.Loading -> renderLoading()
            is CustomerDetailsViewState.Data -> renderData(state)
            is CustomerDetailsViewState.Error -> renderError(state)
        }
    }

    private fun renderLoading(){

    }

    private fun renderData(state: CustomerDetailsViewState.Data){
        (context as CustomerDetailsActivity)?.UpdateHeader(state.customer)
    }

    private fun renderError(state: CustomerDetailsViewState.Error){

    }

}