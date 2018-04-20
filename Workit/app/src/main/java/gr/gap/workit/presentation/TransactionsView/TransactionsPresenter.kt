package gr.gap.workit.presentation.TransactionsView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.usecases.GetTransactionsUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TransactionsPresenter @Inject constructor(private val getTransactionsUseCase: GetTransactionsUseCase) : MviBasePresenter<TransactionsView, TransactionsViewState>() {
    override fun bindIntents() {

        val allIntents = intent (TransactionsView::loadTransactionsIntent)
                .switchMap { getTransactionsUseCase.getTransactions(it)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(allIntents, TransactionsView::render)
    }
}