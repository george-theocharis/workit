package gr.gap.workit.presentation.CustomerDetailsView

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_customer_details.*

class CustomerDetailsFragment : MviFragment<CustomerDetailsView, CustomerDetailsPresenter>(), CustomerDetailsView {

    companion object {
        var customerId: Int = 0
    }

    private val phonesAdapter: CustomerPhonesAdapter = CustomerPhonesAdapter(ArrayList())
    private val locationsAdapter: CustomerAddressesAdapter = CustomerAddressesAdapter(ArrayList())

    override fun createPresenter(): CustomerDetailsPresenter = App.component.customerDetailsPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_customer_details,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        phonesList.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        phonesList.adapter = phonesAdapter

        locationsList.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        locationsList.adapter = locationsAdapter
    }

    override fun loadCustomerDetailsIntent(): Observable<Int> = Observable.just(customerId)

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

        phonesAdapter.updateList(state.customer.phones!!)

        locationsAdapter.updateList(state.customer.addresses!!)

        emailText.text = state.customer.email
    }

    private fun renderError(state: CustomerDetailsViewState.Error){

    }

}