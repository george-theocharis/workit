package gr.gap.workit.domain.model

import com.squareup.moshi.Json

data class BookPage(val id: Int?,  val comment: String?, @Json(name="created_at") val createdAt: String?)