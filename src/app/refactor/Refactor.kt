package app.refactor

fun main() {
    println(Repository.getInstance(object : DataSource {}).formattedUserNames)
}