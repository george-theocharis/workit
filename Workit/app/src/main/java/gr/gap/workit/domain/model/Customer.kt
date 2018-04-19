package gr.gap.workit.domain.model

import com.squareup.moshi.Json

data class Customer (val id: Int, val email: String, @Json(name="first_name")var firstName: String,
                     @Json(name="last_name") var lastName: String, @Json(name="phones_list") val phones: List<CustomerPhone>?, @Json(name="customer_addresses_list") val addresses: List<CustomerAddress>?)