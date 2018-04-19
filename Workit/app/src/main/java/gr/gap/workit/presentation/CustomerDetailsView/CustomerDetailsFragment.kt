package gr.gap.workit.presentation.CustomerDetailsView

import android.app.Activity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_customer_details.*
import kotlinx.android.synthetic.main.list_element_customer.*
import kotlinx.android.synthetic.main.list_element_customer.view.*

class CustomerDetailsFragment : MviFragment<CustomerDetailsView, CustomerDetailsPresenter>(), CustomerDetailsView {

    private lateinit var phonesRecycler: RecyclerView
    private lateinit var addressesRecycler: RecyclerView

    override fun createPresenter(): CustomerDetailsPresenter = App.component.customerDetailsPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val v = inflater.inflate(R.layout.fragment_customer_details,container,false)

        phonesRecycler = v.findViewById(R.id.phonesList)
        phonesRecycler.layoutManager = LinearLayoutManager(context)
        addressesRecycler = v.findViewById(R.id.locationsList)
        addressesRecycler.layoutManager = LinearLayoutManager(context)

        return v
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
        phonesRecycler.adapter = CustomerPhonesAdapter(state.customer.phones!!)
        addressesRecycler.adapter = CustomerAddressesAdapter(state.customer.addresses!!)
        emailText.text = state.customer.email
    }

    private fun renderError(state: CustomerDetailsViewState.Error){

    }

}