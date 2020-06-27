import io.ktor.application.call
import io.ktor.response.respondText
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty


fun main() {
    val port = 9090
    embeddedServer(Netty, port) {
        routing {
            get("/") {
                call.respondText("hello from ktor")
            }
        }
    }.start(wait = true)
}