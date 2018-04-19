package gr.gap.workit.presentation.BooksView

import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import gr.gap.workit.domain.usecases.GetBooksUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class BooksPresenter @Inject constructor(private val getBooksUseCase: GetBooksUseCase) : MviBasePresenter<BooksView, BooksViewState>() {
    override fun bindIntents() {
        val allIntents = intent (BooksView::loadBooksIntent)
                .switchMap { getBooksUseCase.getBooks(1)}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(allIntents, BooksView::render)
    }
}