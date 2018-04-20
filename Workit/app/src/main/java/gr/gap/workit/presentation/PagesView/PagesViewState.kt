package gr.gap.workit.presentation.PagesView

import gr.gap.workit.domain.model.BookPage

sealed class PagesViewState{
    object Loading : PagesViewState()
    data class Data(val pages: List<BookPage>): PagesViewState()
    data class Error(val error: Throwable) : PagesViewState()
}