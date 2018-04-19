package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.BooksApi
import gr.gap.workit.presentation.BooksView.BooksViewState
import io.reactivex.Observable
import javax.inject.Inject

class GetBooksUseCase @Inject constructor(private val booksApi: BooksApi) {

    fun getBooks(id: Int): Observable<BooksViewState> =
        booksApi.getBooksOfCustomer(id)
                .map<BooksViewState> { BooksViewState.Data(it)}
                .startWith(BooksViewState.Loading)
                .onErrorReturn { BooksViewState.Error(it)}
}