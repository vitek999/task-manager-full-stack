package modules

import io.ktor.application.Application
import io.ktor.routing.routing
import routes.userRoutes

fun Application.userModule() {
    routing {
        userRoutes()
    }
}