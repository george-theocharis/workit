package gr.gap.workit.data.di.customers

import dagger.Module
import dagger.Provides
import gr.gap.workit.data.di.NetworkModule
import gr.gap.workit.data.network.CustomersApi
import retrofit2.Retrofit
import javax.inject.Singleton


@Module(includes = [(NetworkModule::class)])
class CustomersModule {

    @Singleton
    @Provides
    fun providesCustomersApi(retrofit: Retrofit): CustomersApi = retrofit.create(CustomersApi::class.java)

}