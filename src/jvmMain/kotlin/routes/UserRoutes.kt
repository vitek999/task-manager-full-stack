package routes

import data.dto.UserDto
import io.ktor.application.call
import io.ktor.response.respond
import io.ktor.routing.Route
import io.ktor.routing.get

fun Route.userRoutes() {
    get("/user") {
        call.respond(
            listOf(
                UserDto(1, "phone", "pass", "first", "last", "about"),
                UserDto(2, "phone2", "pass2", "first2", "last2", "about2"),
                UserDto(1, "phone3", "pass3", "first3", "last3", "about3")
            )
        )
    }
}