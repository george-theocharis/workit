package gr.gap.workit.presentation.PagesView
import gr.gap.workit.domain.usecases.GetPagesUseCase
import com.hannesdorfmann.mosby3.mvi.MviBasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class PagesPresenter @Inject constructor(private val getPagesUseCase: GetPagesUseCase) : MviBasePresenter<PagesView, PagesViewState>()
{
    override fun bindIntents() {
        val allIntents = intent (PagesView::loadPagesIntent)
                .switchMap { getPagesUseCase.getPages()}
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

        subscribeViewState(allIntents, PagesView::render)
    }

}