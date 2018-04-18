package gr.gap.workit.data.network

import gr.gap.workit.domain.model.User
import io.reactivex.Observable
import okhttp3.ResponseBody
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface UserApi{

    @GET("me")
    fun getUser(): Observable<User>

    @POST("user")
    fun register(@Body user: User): Observable<ResponseBody>
}