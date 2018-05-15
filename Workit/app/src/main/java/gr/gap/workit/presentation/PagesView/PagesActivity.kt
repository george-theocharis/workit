package gr.gap.workit.presentation.PagesView

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.LinearLayout
import com.hannesdorfmann.mosby3.mvi.MviActivity
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import io.reactivex.Observable
import io.reactivex.disposables.Disposable
import kotlinx.android.synthetic.main.activity_pages.*

class PagesActivity: MviActivity<PagesView, PagesPresenter>(), PagesView{

    private var pagesAdapter = PagesAdapter(ArrayList())
    private lateinit var subscription: Disposable

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pages)

        val layoutManager = LinearLayoutManager(this, LinearLayout.VERTICAL,false)
        pagesRecycler.layoutManager = layoutManager
        subscription = pagesAdapter.selectedPageObservable.subscribe { navigateToPageDetails(it?.id) }
        pagesRecycler.adapter = pagesAdapter
    }

    override  fun onDestroy() {
        super.onDestroy()
        subscription.dispose()
    }

    private fun navigateToPageDetails(id: Int?) {
        print(id)
    }

    override fun loadPagesIntent(): Observable<Boolean> = Observable.just(true)

    override fun render(state: PagesViewState) {
       when(state){
           is PagesViewState.Loading -> renderLoading()
           is PagesViewState.Data -> renderData(state)
           is PagesViewState.Error -> renderError(state)
       }
    }

    private fun renderError(state: PagesViewState.Error) {
        print(state.error.message)
    }

    private fun renderData(state: PagesViewState.Data) {
        pagesAdapter.updateItems(state.pages)
    }

    private fun renderLoading() {
    }

    override fun createPresenter(): PagesPresenter = App.component.pagesPresenter()


}