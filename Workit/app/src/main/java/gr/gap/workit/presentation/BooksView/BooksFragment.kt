package gr.gap.workit.presentation.BooksView

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
import kotlinx.android.synthetic.main.fragment_books.*

class BooksFragment: MviFragment<BooksView, BooksPresenter>(), BooksView{

    override fun createPresenter(): BooksPresenter = App.component.booksPresenter()

    private var booksAdapter = BooksAdapter(ArrayList())

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_books, container, false)

        val layoutManager = LinearLayoutManager(this.context, VERTICAL,false)

        booksRecycler.layoutManager = layoutManager

        booksRecycler.adapter = booksAdapter

        return view
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

    }
}