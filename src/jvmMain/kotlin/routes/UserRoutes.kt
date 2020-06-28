package routes

import io.ktor.application.call
import io.ktor.http.HttpStatusCode
import io.ktor.locations.get
import io.ktor.response.respond
import io.ktor.routing.Route
import modules.Users
import modules.users

fun Route.userRoutes() {
    get<Users> {
        call.respond(users)
    }

    get<Users.Id> { id ->
        val u = users.firstOrNull { it.id == id.id }
        if (u != null) {
            call.respond(HttpStatusCode.OK, u)
        } else {
            call.respond(HttpStatusCode.NoContent)
        }
    }
}