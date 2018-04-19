package gr.gap.workit.domain.model

import com.squareup.moshi.Json

data class Book(val id: Int?, val name: String?, @Json(name="created_at") val createdAt: String?)