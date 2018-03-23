package gr.gap.workit

import android.support.design.widget.Snackbar
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.view.isVisible
import kotlinx.android.synthetic.main.list_element_customer.view.*
import java.util.*


class CustomersAdapter(val customers : ArrayList<Customer>): RecyclerView.Adapter<CustomersAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomersAdapter.ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.list_element_customer, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int = customers.count()

    override fun onBindViewHolder(holder: CustomersAdapter.ViewHolder, position: Int) {
        holder.bindItems(customers[position])
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bindItems(customer: Customer) {
            itemView.customerName.text = customer.firstName + " " + customer.lastName
            itemView.customerIcon.text = customer.firstName[0].toString() + customer.lastName[0].toString()

            itemView.nameLayout.setOnClickListener{
                if(!itemView.actions.isVisible)
                    itemView.actions.setVisibility(View.VISIBLE)
                else
                    itemView.actions.setVisibility(View.GONE)
            }
        }
    }
}