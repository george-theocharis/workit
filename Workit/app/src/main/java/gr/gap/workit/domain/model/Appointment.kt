package gr.gap.workit.domain.model

import com.squareup.moshi.Json

data class Appointment(val id: Int = 0, @Json(name = "appointment_date")val date: String? = null, val notes: String? = null)