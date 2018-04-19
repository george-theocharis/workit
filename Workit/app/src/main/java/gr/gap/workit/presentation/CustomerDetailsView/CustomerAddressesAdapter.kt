package gr.gap.workit.presentation.CustomerDetailsView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.gap.workit.R
import gr.gap.workit.domain.model.CustomerAddress
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.list_element_customer_address.view.*

class CustomerAddressesAdapter(val addresses: ArrayList<CustomerAddress>) : RecyclerView.Adapter<CustomerAddressesAdapter.ViewHolder>() {

    private val addressClickSubject = PublishSubject.create<CustomerAddress>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =  ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.list_element_customer_address, parent,false), addressClickSubject
    )

    override fun getItemCount(): Int = addresses.count()

    override fun onBindViewHolder(holder: CustomerAddressesAdapter.ViewHolder, position: Int) = holder.bindItems(addresses[position])

    fun updateList(addresses: List<CustomerAddress>) {
        this.addresses.clear()
        this.addresses.addAll(addresses)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View, clickSubject: PublishSubject<CustomerAddress>) : RecyclerView.ViewHolder(itemView) {
        val listener: PublishSubject<CustomerAddress> = clickSubject

        fun bindItems(address: CustomerAddress) {

            itemView.setOnClickListener { listener.onNext(address) }

            itemView.address.text = address.address + " " + address.addressNumber + ", " + address.postCode
            itemView.city.text = address.city
            itemView.type.text = address.title
        }
    }
}