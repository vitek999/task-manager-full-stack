import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


fun main() {
    val port = 9090
    embeddedServer(Netty, port, module = Application::mainModule).start(wait = true)
}

fun Application.mainModule() {
    anotherModule()
    routing {
        root()
    }
}

fun Application.anotherModule() {
    routing {
        anotherRouting()
    }
}

fun Routing.root() {
    get("/") {
        call.respondText("hello from ktor")
    }
}

fun Routing.anotherRouting() {
    get("/another") {
        call.respondText("hello from another")
    }
}