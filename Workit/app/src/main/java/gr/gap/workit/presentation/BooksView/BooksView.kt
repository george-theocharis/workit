package gr.gap.workit.presentation.BooksView

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface BooksView : MvpView {
    fun loadBooksIntent(): Observable<Boolean>
    fun render(state: BooksViewState)
}