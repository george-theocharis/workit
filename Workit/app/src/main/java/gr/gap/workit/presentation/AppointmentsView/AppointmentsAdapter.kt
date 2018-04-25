package gr.gap.workit.presentation.AppointmentsView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import gr.gap.workit.R
import gr.gap.workit.domain.model.Appointment
import io.reactivex.Observable
import io.reactivex.subjects.PublishSubject
import android.view.View
import kotlinx.android.synthetic.main.list_element_book.view.*

class AppointmentsAdapter(val appointments : ArrayList<Appointment>): RecyclerView.Adapter<AppointmentsAdapter.ViewHolder>() {

    private val appointmentClickSubject = PublishSubject.create<Appointment>()

    val selectedAppointmentObservable: Observable<Appointment>
        get() = appointmentClickSubject

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.list_element_book, parent, false), appointmentClickSubject
    )

    override fun getItemCount(): Int = appointments.count()

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =  holder.bindItems(appointments[position])

    fun updateItems(appointments: List<Appointment>) {
        this.appointments.clear()
        this.appointments.addAll(appointments)
        notifyDataSetChanged()
    }

    class ViewHolder(itemView: View, private val listener: PublishSubject<Appointment>) : RecyclerView.ViewHolder(itemView) {

        fun bindItems(appointment: Appointment) {

           itemView.bookTitle.text = appointment.notes
           itemView.bookCreatedAt.text = appointment.date

            itemView.setOnClickListener {
                listener.onNext(appointment)
            }
        }
    }
}