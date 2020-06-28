package modules

import data.dto.UserDto
import io.ktor.application.Application
import io.ktor.locations.Location
import io.ktor.routing.routing
import routes.userRoutes

@Location("/users") class Users {
    @Location("/{id}") data class Id(val id: Long)
}

val users = listOf(
    UserDto(1, "phone", "pass", "first", "last", "about"),
    UserDto(2, "phone2", "pass2", "first2", "last2", "about2"),
    UserDto(1, "phone3", "pass3", "first3", "last3", "about3")
)

fun Application.userModule() {
    routing {
        userRoutes()
    }
}