package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Long,
    val phone: String,
    val password: String,
    val firstName: String,
    val lastName: String,
    val aboutMe: String
)