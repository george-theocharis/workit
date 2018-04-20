package gr.gap.workit.presentation.TransactionsView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.gap.workit.R
import gr.gap.workit.domain.model.Book
import gr.gap.workit.domain.model.Transaction
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.list_element_book.view.*

class TransactionsAdapter(private val transactions : ArrayList<Transaction>): RecyclerView.Adapter<TransactionsAdapter.ViewHolder>() {

    private val transactionsClickSubject = PublishSubject.create<Transaction>()

    val selectedTransactionObservable: Observable<Transaction>
        get() = transactionsClickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_element_book, parent, false), transactionsClickSubject
    )

    override fun getItemCount(): Int = transactions.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =  holder.bindItems(transactions[position])

    fun updateItems(transactions: List<Transaction>) {
        this.transactions.clear()
        this.transactions.addAll(transactions)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, private val listener: PublishSubject<Transaction>) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(transaction: Transaction) {

            itemView.bookTitle.text = transaction.notes
            itemView.bookCreatedAt.text = transaction.createdAt

            itemView.setOnClickListener {
                listener.onNext(transaction)
            }
        }
    }
}