package gr.gap.workit.presentation.CustomerDetailsView

import android.content.res.Resources
import android.os.Bundle
import android.support.v4.content.ContextCompat
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import gr.gap.workit.domain.model.CustomerPhone
import io.reactivex.Observable
import kotlinx.android.synthetic.main.fragment_customer_details.*
import java.util.*
import kotlin.collections.ArrayList

class CustomerDetailsFragment : MviFragment<CustomerDetailsView, CustomerDetailsPresenter>(), CustomerDetailsView {

    private val phonesAdapter: CustomerPhonesAdapter = CustomerPhonesAdapter(ArrayList())
    private val locationsAdapter: CustomerAddressesAdapter = CustomerAddressesAdapter(ArrayList())
    private var customerId: Int? = 0

    companion object {
        fun create(customerId: Int) : CustomerDetailsFragment {

            val fragment = CustomerDetailsFragment()

            val bundle = Bundle()
            bundle.putInt("customerId", customerId)

            fragment.arguments = bundle

            return fragment
        }
    }

    override fun createPresenter(): CustomerDetailsPresenter = App.component.customerDetailsPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        customerId = arguments?.getInt("customerId")
        return inflater.inflate(R.layout.fragment_customer_details,container,false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        phonesList.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        phonesList.adapter = phonesAdapter

        addressesList.layoutManager = LinearLayoutManager(context, LinearLayout.VERTICAL, false)
        addressesList.adapter = locationsAdapter
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
        (context as CustomerDetailsActivity).UpdateHeader(state.customer)

        if (state.customer.email == null || state.customer.email.isBlank())
            showAddEmail()
        else
            emailText.text = state.customer.email

        if (state.customer?.phones != null)
            phonesAdapter.updateList(state.customer?.phones)
        else
            showAddPhone()

        if (state.customer?.addresses != null)
            locationsAdapter.updateList(state.customer?.addresses)
        else
            showAddAddress()
    }

    private fun renderError(state: CustomerDetailsViewState.Error){

    }

    private fun showAddEmail(){
        emailText.visibility = View.GONE
        addEmail.visibility = View.VISIBLE
        addEmailImage.visibility = View.VISIBLE
    }

    private fun showAddPhone(){
        phonesList.visibility = View.GONE
        addPhone.visibility = View.VISIBLE
        addPhoneImage.visibility = View.VISIBLE
    }

    private fun showAddAddress(){
        addressesList.visibility = View.GONE
        addAddress.visibility = View.VISIBLE
        addAddressImage.visibility = View.VISIBLE
    }
}