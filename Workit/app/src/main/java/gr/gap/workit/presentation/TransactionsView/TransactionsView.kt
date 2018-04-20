package gr.gap.workit.presentation.TransactionsView

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface TransactionsView: MvpView {
    fun loadTransactionsIntent() : Observable<Int>
    fun render(state: TransactionsViewState)
}