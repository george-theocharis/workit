package gr.gap.workit.presentation.PagesView

import com.hannesdorfmann.mosby3.mvp.MvpView
import io.reactivex.Observable

interface PagesView : MvpView {
    fun loadPagesIntent(): Observable<Boolean>
    fun render(state: PagesViewState)
}