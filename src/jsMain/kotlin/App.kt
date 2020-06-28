import data.dto.UserDto
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import react.RProps
import react.dom.*
import react.functionalComponent
import react.useEffect
import react.useState

val scope = MainScope()

val App = functionalComponent<RProps> {
    val (userList, setUserList) = useState(emptyList<UserDto>())

    useEffect {
        scope.launch {
            setUserList(getUsers())
        }
    }

    h1 {
        + "Users"
    }

    ul {
        userList.forEach { item ->
            li {
                key = item.id.toString()
                +item.toString()
            }
        }
    }
}