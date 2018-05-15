package gr.gap.workit.presentation.BooksView

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import gr.gap.workit.presentation.CustomerDetailsView.CustomerDetailsActivity
import gr.gap.workit.presentation.PagesView.PagesActivity
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_books.*

class BooksFragment: MviFragment<BooksView, BooksPresenter>(), BooksView{

    override fun createPresenter(): BooksPresenter = App.component.booksPresenter()

    private var booksAdapter = BooksAdapter(ArrayList())
    private lateinit var subscription: Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_books, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(this.context, VERTICAL,false)

        booksRecycler.layoutManager = layoutManager

        subscription = booksAdapter.selectedBookObservable.subscribe { navigateToPages(it?.id) }

        booksRecycler.adapter = booksAdapter
    }

    override  fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }

    private fun navigateToPages(bookId: Int?) {
        val intent = Intent(this.context, PagesActivity::class.java)
        intent.putExtra("bookId", bookId)
        (context as Activity).startActivity(intent)
    }

    override fun loadBooksIntent(): Observable<Boolean> = Observable.just(true)

    override fun render(state: BooksViewState) {
        when (state){
            is BooksViewState.Loading -> renderLoading()
            is BooksViewState.Data -> renderData(state)
            is BooksViewState.Error -> renderError(state)
        }
    }

    private fun renderLoading(){

    }

    private fun renderData(state: BooksViewState.Data){
        booksAdapter.updateItems(state.books)
    }

    private fun renderError(state: BooksViewState.Error){
        print(state.error.message)
    }
}