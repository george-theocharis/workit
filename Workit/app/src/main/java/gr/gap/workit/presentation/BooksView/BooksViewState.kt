package gr.gap.workit.presentation.BooksView

import gr.gap.workit.domain.model.Book

sealed class BooksViewState {
    object Loading : BooksViewState()
    data class Data(val books: List<Book>) : BooksViewState()
    data class Error(val error: Throwable) : BooksViewState()
}