package gr.gap.workit.domain.model

import com.squareup.moshi.Json

data class Transaction(val id: Int?, @Json(name="type_id")val typeId: Int?, val notes: String?, val amount: Float?, @Json(name="created_at")val createdAt: String?, val currency: String?)