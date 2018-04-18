package gr.gap.workit.data.di.register

import dagger.Component
import gr.gap.workit.presentation.RegisterView.RegisterPresenter
import javax.inject.Singleton


@Singleton
@Component(modules = [(RegisterUserModule::class)])
interface RegisterUserComponent {
    fun presenter(): RegisterPresenter
}