package gr.gap.workit.data.di.login

import dagger.Module
import dagger.Provides
import gr.gap.workit.domain.usecases.LoginUserUseCase

@Module
class LoginModule {
    @Provides
    fun loginUserUseCase() = LoginUserUseCase()
}
