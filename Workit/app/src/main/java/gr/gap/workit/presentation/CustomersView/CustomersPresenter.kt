package gr.gap.workit.presentation.LoginView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.usecases.GetCustomersUseCase
import gr.gap.workit.domain.usecases.LoginUserUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by developer1 on 26/03/2018.
 */
class CustomersPresenter @Inject constructor(private val getCustomersUseCase: GetCustomersUseCase) : MviBasePresenter<CustomersView, CustomersViewState>() {
    override fun bindIntents() {

        val loginViewStateObs = intent (CustomersView::loadCustomersIntent)
                .switchMap { getCustomersUseCase.getCustomers()}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(loginViewStateObs, CustomersView::render)
    }
}