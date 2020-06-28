package database.dao

import data.dto.UserDto
import database.table.UserTable
import org.jetbrains.exposed.dao.IntEntity
import org.jetbrains.exposed.dao.IntEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class UserDao(id: EntityID<Int>) : IntEntity(id) {
    companion object : IntEntityClass<UserDao>(UserTable)

    val firstName by UserTable.firstName
    val lastName by UserTable.lastName
    val patronymic by UserTable.patronymic
    val email by UserTable.email
    val password by UserTable.password

    override fun toString(): String = "$firstName $lastName $patronymic $email $password"
}

fun UserDao.toDto() = UserDto(
    id = id.value.toLong(),
    firstName = firstName,
    lastName = lastName,
    patronymic = patronymic,
    email = email,
    password = password
)