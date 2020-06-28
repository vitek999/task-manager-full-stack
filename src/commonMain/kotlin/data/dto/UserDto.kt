package data.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Long,
    val firstName: String,
    val lastName: String,
    val patronymic: String,
    val email: String,
    val password: String
)