package gr.gap.workit.presentation.BooksView

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import io.reactivex.Observable

class BooksFragment:MviFragment<BooksView, BooksPresenter>(), BooksView{

    override fun createPresenter(): BooksPresenter = App.component.booksPresenter()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_books, container, false)
    }

    override fun loadBooksIntent(): Observable<Boolean> = Observable.just(true)

    override fun render(state: BooksViewState) {
        when (state){
            is BooksViewState.Loading -> renderLoading()
            is BooksViewState.Data -> renderData()
            is BooksViewState.Error -> renderError(state)
        }
    }

    private fun renderLoading(){

    }

    private fun renderData(){

    }

    private fun renderError(state: BooksViewState.Error){

    }
}