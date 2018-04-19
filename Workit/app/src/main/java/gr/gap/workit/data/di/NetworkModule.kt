package gr.gap.workit.data.di

import com.squareup.moshi.KotlinJsonAdapterFactory
import com.squareup.moshi.Moshi
import dagger.Module
import dagger.Provides
import gr.gap.workit.data.network.BooksApi
import gr.gap.workit.data.network.CustomersApi
import gr.gap.workit.data.network.UserApi
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
class NetworkModule {

    companion object {
        private const val BaseUrl: String = "http://www.argyrispro.eu/workit/public/api/"
    }

    @Singleton
    @Provides
    fun provideUserApi(retrofit: Retrofit): UserApi =
         retrofit.create(UserApi::class.java)

    @Singleton
    @Provides
    fun provideCustomersApi(retrofit: Retrofit): CustomersApi = retrofit.create(CustomersApi::class.java)

    @Singleton
    @Provides
    fun provideBooksApi(retrofit: Retrofit): BooksApi =
            retrofit.create(BooksApi::class.java)

    @Singleton
    @Provides
    fun provideJsonConverter(): Moshi {
        return Moshi.Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
    }

    @Singleton
    @Provides
    fun provideRetrofit(moshi: Moshi): Retrofit =
            Retrofit.Builder()
                    .baseUrl(Companion.BaseUrl)
                    .addConverterFactory(MoshiConverterFactory.create(moshi))
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                    .build()


}


