package gr.gap.workit.presentation.TransactionsView

import gr.gap.workit.domain.model.Transaction

sealed class TransactionsViewState {
    object Loading : TransactionsViewState()
    data class Data(val transactions: List<Transaction>) : TransactionsViewState()
    data class Error(val error: Throwable) : TransactionsViewState()
}