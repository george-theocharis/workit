package gr.gap.workit.presentation.CustomersView

import android.content.Context
import android.content.Intent
import android.support.v4.content.ContextCompat.startActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout.VERTICAL
import com.hannesdorfmann.mosby3.mvi.layout.MviFrameLayout
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import gr.gap.workit.domain.model.Customer
import gr.gap.workit.presentation.CustomerDetailsView.CustomerDetailsActivity
import gr.gap.workit.presentation.HomeView.HomeActivity
import gr.gap.workit.presentation.LoginView.CustomersPresenter
import gr.gap.workit.presentation.LoginView.CustomersView
import gr.gap.workit.presentation.LoginView.CustomersViewState
import io.reactivex.Observable
import kotlinx.android.synthetic.main.view_customers.view.*

class Customers :  CustomersView, MviFrameLayout<CustomersView, CustomersPresenter> {

    override fun createPresenter(): CustomersPresenter = App.component.customersPresenter()

    private var customersAdapter = CustomersAdapter(ArrayList())

    constructor(context: Context) : this(context, null)
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    init {
        LayoutInflater.from(context)
                .inflate(R.layout.view_customers, this, true)

        val layoutManager = LinearLayoutManager(this.context, VERTICAL,false)

        customersRecycler.layoutManager = layoutManager

        customersRecycler.adapter = customersAdapter

        customersAdapter.customerClickObservable.subscribe { navigateToCustomerDetails() }
    }

    private fun navigateToCustomerDetails() {
        val intent = Intent(this.context, CustomerDetailsActivity::class.java)
        (context as HomeActivity).startActivity(intent)
    }

    override fun loadCustomersIntent(): Observable<Boolean> = Observable.just(true)

    override fun render(state: CustomersViewState) {
        when(state) {
            is CustomersViewState.Loading -> renderLoading()
            is CustomersViewState.Data -> renderCustomers(state.customers)
            is CustomersViewState.Error -> renderError(state.error)
        }
    }

    private fun renderError(error: Throwable) {
    }

    private fun renderCustomers(customers: List<Customer>) {
        customersAdapter.updateItems(customers)
    }

    private fun renderLoading() {
    }

}




