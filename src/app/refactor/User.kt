package app.refactor

data class User(var firstName: String, var lastName: String? = null) {

    val formattedName: String?
        get() = when {
            lastName != null && firstName != null -> "$firstName $lastName"
            lastName != null -> lastName
            firstName != null -> firstName
            else -> "UnKnown"
        }
}