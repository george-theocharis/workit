package gr.gap.workit.presentation.AddCustomerView

import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.toast
import com.hannesdorfmann.mosby3.mvi.MviActivity
import com.jakewharton.rxbinding2.view.RxView
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import gr.gap.workit.domain.model.Customer
import io.reactivex.Observable
import kotlinx.android.synthetic.main.activity_add_customer.*

class AddCustomerActivity : MviActivity<AddCustomerView, AddCustomerPresenter>(), AddCustomerView {

    override fun render(state: AddCustomerViewState) {
        when(state) {
            is AddCustomerViewState.Loading -> renderLoading()
            is AddCustomerViewState.Data -> renderData()
            is AddCustomerViewState.Error -> renderError(state)
        }
    }

    private fun renderError(state: AddCustomerViewState.Error) {
      toast("${state.error}", Toast.LENGTH_LONG).show()

    }

    private fun renderData() {

        finish()
    }

    private fun renderLoading() {

    }

    override fun addCustomerIntent(): Observable<Customer> = RxView.clicks(buttonDone)
            .flatMap { _ -> Observable.just(Customer(10,"customer@mobile.com","Mr","Workit")) }

    override fun createPresenter(): AddCustomerPresenter = App.component.addCustomerPresenter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_customer)
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(R.anim.stay, R.anim.slide_down)
    }
}
