package gr.gap.workit.domain.model

import com.squareup.moshi.Json

data class CustomerAddress(val id: Int? = null, @Json(name="customer_id") val customerId: Int? = null, val title: String? = null, val address: String? = null, @Json(name="address_number") val addressNumber: String? = null,
                           val city: String? = null, @Json(name="post_code") val postCode: String? = null, val lat: String? = null, val lon: String? = null)