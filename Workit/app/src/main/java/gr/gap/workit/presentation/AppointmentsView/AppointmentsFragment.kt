package gr.gap.workit.presentation.AppointmentsView

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout.VERTICAL
import com.hannesdorfmann.mosby3.mvi.MviFragment
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.fragment_appointments.*


class AppointmentsFragment: MviFragment<AppointmentsView, AppointmentsPresenter>(), AppointmentsView{

    override fun createPresenter(): AppointmentsPresenter = App.component.appointmentsPresenter()

    private var appointmentsAdapter = AppointmentsAdapter(ArrayList())
    private lateinit var subscription: Disposable

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? =
            inflater.inflate(R.layout.fragment_appointments, container, false)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layoutManager = LinearLayoutManager(this.context, VERTICAL,false)

        appointmentsRecycler.layoutManager = layoutManager

        subscription = appointmentsAdapter.selectedBookObservable.subscribe { navigateToPages(it?.id) }

        appointmentsRecycler.adapter = appointmentsAdapter
    }

    override  fun onDestroy() {
        super.onDestroy()
        subscription?.dispose()
    }

    private fun navigateToPages(bookId: Int?) {

    }


    override fun render(state: AppointmentsViewState) {
        when (state){
            is AppointmentsViewState.Loading -> renderLoading()
            is AppointmentsViewState.Data -> renderData(state)
            is AppointmentsViewState.Error -> renderError(state)
        }
    }

    private fun renderLoading(){

    }

    private fun renderData(state: AppointmentsViewState.Data){
        appointmentsAdapter.updateItems(state.appointments)
    }

    private fun renderError(state: AppointmentsViewState.Error){

    }
}