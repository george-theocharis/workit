package gr.gap.workit.presentation.TransactionsView

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_books.*


class TransactionsFragment: MviFragment<TransactionsView, TransactionsPresenter>(), TransactionsView{

    override fun createPresenter(): TransactionsPresenter = App.component.transactionsPresenter()

    private var transactionsAdapter = TransactionsAdapter(ArrayList())
    private lateinit var subscription: Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_books, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(this.context, VERTICAL,false)

        booksRecycler.layoutManager = layoutManager

        subscription = transactionsAdapter.selectedTransactionObservable.subscribe {  }

        booksRecycler.adapter = transactionsAdapter
    }

    override  fun onDestroy() {
        super.onDestroy()
        subscription?.dispose()
    }

    override fun loadTransactionsIntent(): Observable<Int> = Observable.just(1)

    override fun render(state: TransactionsViewState) {
        when (state){
            is TransactionsViewState.Loading -> renderLoading()
            is TransactionsViewState.Data -> renderData(state)
            is TransactionsViewState.Error -> renderError(state)
        }
    }

    private fun renderLoading(){

    }

    private fun renderData(state: TransactionsViewState.Data){
        transactionsAdapter.updateItems(state.transactions)
    }

    private fun renderError(state: TransactionsViewState.Error){

    }
}