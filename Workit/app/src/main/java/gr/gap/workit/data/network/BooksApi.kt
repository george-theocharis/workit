package gr.gap.workit.data.network

import gr.gap.workit.domain.model.Book
import gr.gap.workit.domain.model.BookPage
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface BooksApi {

    @GET("customers/{customer_id}/books")
    fun getBooksOfCustomer(@Path("customer_id") customerId: Int? = null): Observable<List<Book>>

    @GET("books/{book_id}/pages")
    fun getPagesOfBook(@Path("book_id") bookId: Int? = null): Observable<List<BookPage>>
}