package gr.gap.workit.domain.model

import com.squareup.moshi.Json

/**
 * Created by developer1 on 26/03/2018.
 */
data class User(val id: Int = 0, val email: String, val password: String= "", val first_name: String= "", val last_name : String = "")

