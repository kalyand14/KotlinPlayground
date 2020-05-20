package app.refactor

import java.util.*

class Repository private constructor(dataSource: DataSource) {

    private var users: MutableList<User> = mutableListOf(User(firstName = "Jane"), User(firstName = "John"), User(firstName = "Anne", lastName = "Doe"))

    fun getUsers(): List<User> {
        return users
    }

    val formattedUserNames: List<String>
        get() {

            return users.map { user ->
                val name: String = ""
                name
            }

            /*  val userNames: MutableList<String> = ArrayList(users.size)
              for (user in users) {
                  user?.formattedName?.let { userNames.add(it) }
              }
              return userNames*/
        }

    companion object : SingletonHolder<Repository, DataSource>(::Repository)
}