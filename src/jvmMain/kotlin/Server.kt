import io.ktor.application.Application
import io.ktor.application.call
import io.ktor.application.install
import io.ktor.features.CORS
import io.ktor.features.ContentNegotiation
import io.ktor.http.HttpMethod
import io.ktor.locations.Locations
import io.ktor.response.respondText
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.routing
import io.ktor.serialization.json
import io.ktor.server.engine.embeddedServer
import io.ktor.server.netty.Netty
import modules.userModule
import org.jetbrains.exposed.sql.Database


fun main() {
    Database.connect(
        "jdbc:mysql://localhost:3306/task_manager_db?autoReconnect=true&useUnicode=true&characterEncoding=UTF-8&allowMultiQueries=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC",
        driver = "com.mysql.jdbc.Driver",
        user = "root",
        password = "root"
    )

    val port = 9090
    embeddedServer(Netty, port, module = Application::mainModule).start(wait = true)
}

fun Application.mainModule() {

    install(ContentNegotiation) {
        json()
    }

    install(Locations)

    install(CORS) {
        method(HttpMethod.Get)
        method(HttpMethod.Post)
        method(HttpMethod.Delete)
        anyHost()
    }

    anotherModule()
    userModule()
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