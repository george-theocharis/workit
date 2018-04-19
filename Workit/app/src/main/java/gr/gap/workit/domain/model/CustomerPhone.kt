package gr.gap.workit.domain.model

import com.squareup.moshi.Json

data class CustomerPhone(val id: Int? = null, @Json(name="customer_id") val customerId: Int? = null, val
    title: String? = null, @Json(name="phone_number") val number: String? = null)