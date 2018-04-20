package gr.gap.workit.domain.usecases

import gr.gap.workit.data.network.BooksApi
import gr.gap.workit.presentation.PagesView.PagesViewState
import io.reactivex.Observable
import javax.inject.Inject

class GetPagesUseCase @Inject constructor(private val booksApi: BooksApi){

    fun getPages(): Observable<PagesViewState> {
        return booksApi.getPagesOfBook(2)
                .map<PagesViewState> { PagesViewState.Data(it) }
                .startWith(PagesViewState.Loading)
                .onErrorReturn { PagesViewState.Error(it) }
    }
}
