package gr.gap.workit.presentation.PagesView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.gap.workit.R
import gr.gap.workit.domain.model.BookPage
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.list_element_page.view.*

class PagesAdapter(val pages : ArrayList<BookPage>): RecyclerView.Adapter<PagesAdapter.ViewHolder>() {

    private val pageClickSubject = PublishSubject.create<BookPage>()

    val selectedPageObservable: Observable<BookPage>
        get() = pageClickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_element_page, parent, false), pageClickSubject
    )

    override fun getItemCount(): Int = pages.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =  holder.bindItems(pages[position])

    fun updateItems(pages: List<BookPage>) {
        this.pages.clear()
        this.pages.addAll(pages)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, private val listener: PublishSubject<BookPage>) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(page: BookPage) {

            itemView.pageComment.text = page.comment
            itemView.pageCreatedAt.text = page.createdAt

            itemView.setOnClickListener {
                listener.onNext(page)
            }
        }
    }
}