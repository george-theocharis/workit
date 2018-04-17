package gr.gap.workit.presentation.CustomersView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import gr.gap.workit.R
import gr.gap.workit.domain.model.Customer
import kotlinx.android.synthetic.main.list_element_customer.view.*
import java.util.*


class CustomersAdapter(val customers : ArrayList<Customer>): RecyclerView.Adapter<CustomersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_element_customer, parent, false)
    )

    override fun getItemCount(): Int = customers.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItems(customers[position])

    fun updateItems(customers: List<Customer>) {
        this.customers.clear()
        this.customers.addAll(customers)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(customer: Customer) {
            itemView.customerName.text = customer.firstName + " " + customer.lastName
            itemView.customerIcon.text = customer.firstName[0].toString() + customer.lastName[0].toString()

            itemView.nameLayout.setOnClickListener{
                if(!itemView.actions.isVisible)
                    itemView.actions.visibility = View.VISIBLE
                else
                    itemView.actions.visibility = View.GONE
            }
        }
    }
}