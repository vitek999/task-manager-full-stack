package database.table

import org.jetbrains.exposed.dao.id.IntIdTable

object UserTable : IntIdTable("user") {
    val firstName = varchar("first_name", 255)
    val lastName = varchar("last_name", 255)
    val patronymic = varchar("patronymic", 255)
    val email = varchar("email", 255)
    val password = varchar("password", 255)
}