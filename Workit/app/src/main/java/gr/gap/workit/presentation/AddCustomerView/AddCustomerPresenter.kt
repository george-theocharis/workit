package gr.gap.workit.presentation.AddCustomerView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.UseCases.AddCustomerUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

/**
 * Created by George Theocharis on 4/18/2018.
 */
class AddCustomerPresenter @Inject constructor(private val addCustomerUseCase: AddCustomerUseCase) : MviBasePresenter<AddCustomerView, AddCustomerViewState>() {

    override fun bindIntents() {

        val addCustomerObs = intent (AddCustomerView::addCustomerIntent)
                .switchMap { addCustomerUseCase.add(it)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(addCustomerObs, AddCustomerView::render)
    }
}