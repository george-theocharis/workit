package gr.gap.workit.presentation.AddCustomerView

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.RxView
import gr.gap.workit.R
import gr.gap.workit.data.di.addCustomer.AddCustomerModule
import gr.gap.workit.data.di.addCustomer.DaggerAddCustomerComponent
import gr.gap.workit.data.di.customers.CustomersModule
import gr.gap.workit.domain.model.Customer
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_add_customer.*

class AddCustomerActivity : MviActivity<AddCustomerView, AddCustomerPresenter>(), AddCustomerView {

    override fun render(state: AddCustomerViewState) {
      when(state){
          is AddCustomerViewState.Loading -> renderLoading()
      }
    }

    private fun renderLoading() {

    }

    override fun addCustomerIntent(): Observable<Customer> = RxView.clicks(buttonAdd)
            .flatMap { _ -> Observable.just(Customer(1,"","","")) }

    override fun createPresenter(): AddCustomerPresenter = DaggerAddCustomerComponent.builder()
            .addCustomerModule(AddCustomerModule()).build().presenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.stay, R.anim.slide_down)
    }
}
