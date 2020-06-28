import data.dto.UserDto
import io.ktor.client.HttpClient
import io.ktor.client.features.json.JsonFeature
import io.ktor.client.features.json.serializer.KotlinxSerializer
import io.ktor.client.request.get

val client = HttpClient {
    install(JsonFeature) { serializer = KotlinxSerializer() }
}

suspend fun getUsers(): List<UserDto> = client.get("http://localhost:9090/users")