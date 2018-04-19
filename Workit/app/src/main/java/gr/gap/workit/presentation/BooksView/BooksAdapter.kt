package gr.gap.workit.presentation.BooksView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.gap.workit.R
import gr.gap.workit.domain.model.Book
import kotlinx.android.synthetic.main.list_element_book.view.*

class BooksAdapter(val books : ArrayList<Book>): RecyclerView.Adapter<BooksAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_element_book, parent, false)
    )

    override fun getItemCount(): Int = books.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(books[position])
    }

    fun updateItems(books: List<Book>) {
        this.books.clear()
        this.books.addAll(books)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(book: Book) {
            itemView.bookTitle.text = book.name
            itemView.bookCreatedAt.text = book.createdAt
        }
    }
}