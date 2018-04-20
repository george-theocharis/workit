package gr.gap.workit.presentation.PagesView

import android.os.Bundle
import com.hannesdorfmann.mosby3.mvi.MviActivity
import gr.gap.workit.R
import gr.gap.workit.data.di.App
import io.reactivex.Observable

class PagesActivity: MviActivity<PagesView, PagesPresenter>(), PagesView{

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pages)
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
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun renderData(state: PagesViewState.Data) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    private fun renderLoading() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun createPresenter(): PagesPresenter = App.component.pagesPresenter()


}