package gr.gap.workit.presentation.CustomersView

import android.app.Activity
import android.app.Notification
import android.support.v7.widget.RecyclerView
import android.transition.Fade
import android.transition.TransitionManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import gr.gap.workit.R
import gr.gap.workit.domain.model.Customer
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import kotlinx.android.synthetic.main.list_element_customer.view.*
import java.util.*
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.net.Uri
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat.*
import android.support.v4.content.PermissionChecker
import android.view.ActionMode
import gr.gap.workit.domain.utilities.Utils
import kotlinx.android.synthetic.main.activity_login.view.*
import java.security.Permission


class CustomersAdapter(private val customers : ArrayList<Customer>): RecyclerView.Adapter<CustomersAdapter.ViewHolder>() {

    private val customerClickSubject = PublishSubject.create<Customer>()

    val customerClickObservable: Observable<Customer>
        get() = customerClickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder = ViewHolder(
             LayoutInflater.from(parent.context).inflate(R.layout.list_element_customer, parent, false), customerClickSubject
    )

    override fun getItemCount(): Int = customers.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bindItems(customers[position])


    fun updateItems(customers: List<Customer>) {
        this.customers.clear()
        this.customers.addAll(customers)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView : View, clickSubject: PublishSubject<Customer>) : RecyclerView.ViewHolder(itemView){

        val listener: PublishSubject<Customer> = clickSubject

        fun bindItems(customer: Customer) {
            itemView.setOnClickListener {
                TransitionManager.beginDelayedTransition(it as ViewGroup, Fade())
                itemView.actions.visibility = if (itemView.actions.visibility == View.VISIBLE) View.GONE else View.VISIBLE
            }
            //temView.call.setOnClickListener{
            //   if (checkSelfPermission(it.context, "PHONE_CALL") ==  PackageManager.PERMISSION_GRANTED){
            //       if (customer.phones?.count() == 1){
            //           var intent = Intent("ACTION_CALL", Uri.parse(customer.phones.first().toString()))
            //           it.context.startActivity(intent)
            //       }
            //       else{
            //       }
            //   }
            //   else{
            //       ActivityCompat.requestPermissions()
            //   }
            //
            //}
            itemView.more.setOnClickListener{listener.onNext(customer)}
            itemView.customerName.text = customer.firstName + " " + customer.lastName
            itemView.customerIcon.text = customer.firstName[0].toString() + customer.lastName[0].toString()

            var bg = getDrawable(itemView.context, R.drawable.circle)
            bg?.setTint(Utils.getRandomColor())
            itemView.customerIcon.background = bg
        }
    }
}