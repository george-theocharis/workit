package gr.gap.workit.data.network

import gr.gap.workit.domain.model.Customer
import retrofit2.http.GET
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Path

interface CustomersApi {

    @GET("customers")
    fun getCustomers(): Observable<List<Customer>>

    @GET("customers/{id}")
    fun getCustomer(@Path("id") id: Int): Observable<Customer>

    @POST("customer")
    fun addCustomer(@Body customer: Customer): Observable<ResponseBody>
}