package gr.gap.workit.data.di

import dagger.Provides
import dagger.Reusable
import gr.gap.workit.data.network.CustomersApi
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideCustomersApi(retrofit: Retrofit): CustomersApi {
        return retrofit.create(CustomersApi::class.java)
    }

    @Provides
    @Reusable
    @JvmStatic
    internal fun provideRetrofitInterface(): Retrofit {
        return Retrofit.Builder()
                //.baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                .build()
    }
}