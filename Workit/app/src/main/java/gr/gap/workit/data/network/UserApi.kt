package gr.gap.workit.data.network

import gr.gap.workit.domain.model.User
import io.reactivex.Observable
import retrofit2.http.GET

interface UserApi{

    @GET("/me")
    fun getUser(): Observable<User>
}