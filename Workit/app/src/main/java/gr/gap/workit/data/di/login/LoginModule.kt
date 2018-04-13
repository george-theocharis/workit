package gr.gap.workit.data.di.login

import dagger.Module
import dagger.Provides
import gr.gap.workit.data.network.UserApi
import gr.gap.workit.domain.usecases.LoginUserUseCase
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class LoginModule {

    @Provides
    fun userApi(): UserApi =
         Retrofit.Builder().baseUrl("http://www.argyrispro.eu/workit/public/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
                .create(UserApi::class.java)

}
