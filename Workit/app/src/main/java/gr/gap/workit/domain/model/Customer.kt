package gr.gap.workit.domain.model

data class Customer (val id : Int, val refStoreId : Int, val refUserId: Int, val email : String, var firstName : String, var lastName : String )