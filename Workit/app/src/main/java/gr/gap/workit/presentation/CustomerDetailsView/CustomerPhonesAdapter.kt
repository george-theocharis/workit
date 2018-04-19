package gr.gap.workit.presentation.CustomerDetailsView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.gap.workit.R
import gr.gap.workit.domain.model.CustomerPhone
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.list_element_customer_phone.view.*

class CustomerPhonesAdapter(val phones: ArrayList<CustomerPhone>) : RecyclerView.Adapter<CustomerPhonesAdapter.ViewHolder>() {

    private val phoneClickSubject = PublishSubject.create<CustomerPhone>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_element_customer_phone, parent,false), phoneClickSubject
    )

    override fun getItemCount(): Int = phones.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItems(phones[position])

    fun updateList(phones: List<CustomerPhone>) {
        this.phones.clear()
        this.phones.addAll(phones)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View, clickSubject: PublishSubject<CustomerPhone>) : RecyclerView.ViewHolder(itemView) {

        val listener: PublishSubject<CustomerPhone> = clickSubject

        fun bindItems(phone: CustomerPhone) {

            itemView.setOnClickListener { listener.onNext(phone) }

            itemView.phoneNumber.text = phone.number
            itemView.phoneType.text = phone.title
        }
    }
}