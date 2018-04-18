package gr.gap.workit.data.di.addCustomer

import dagger.Module
import dagger.Provides
import gr.gap.workit.data.di.NetworkModule
import gr.gap.workit.data.network.CustomersApi
import gr.gap.workit.domain.UseCases.AddCustomerUseCase
import retrofit2.Retrofit
import javax.inject.Singleton

/**
 * Created by George Theocharis on 4/18/2018.
 */

@Module(includes = [(NetworkModule::class)])
class AddCustomerModule {

    @Singleton
    @Provides
    fun providesCustomersApi(retrofit: Retrofit): CustomersApi = retrofit.create(CustomersApi::class.java)
}