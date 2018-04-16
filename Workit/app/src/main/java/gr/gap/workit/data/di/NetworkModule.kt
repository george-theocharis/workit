package gr.gap.workit.data.di

import dagger.Module
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    companion object {
        private const val BaseUrl: String = "http://www.argyrispro.eu/workit/public/api/"
    }

    @Provides
    fun providesRetrofit(): Retrofit =
            Retrofit.Builder()
                    .baseUrl(Companion.BaseUrl)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()

}


