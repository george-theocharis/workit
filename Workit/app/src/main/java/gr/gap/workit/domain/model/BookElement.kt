package gr.gap.workit.domain.model

import com.squareup.moshi.Json

data class BookElement (val id: Int?, @Json(name="book_element_key") val key: String?,  @Json(name="book_element_value") val value: String?)