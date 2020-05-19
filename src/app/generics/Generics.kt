package app.generics

fun main() {

    val isStubbed = true

    val dataSource = when {
        isStubbed -> LocalDataSource()
        else -> RemoteDataSource()
    }
    val dataManager = DataManager(dataSource)
    dataManager.open()
    println(dataManager.read("read"))
    dataManager.close()

}


interface DataSource {
    fun create()
    fun update()
    fun read(): String
    fun delete()
}

class RemoteDataSource : DataSource {
    override fun create() {
        println("Creating record in remote data source")
    }

    override fun update() {
        println("Updating record in remote data source")
    }

    override fun read(): String {
        return "Reading record in remote data source"
    }

    override fun delete() {
        println("Deleting record in remote data source")
    }

}

class LocalDataSource : DataSource {
    override fun create() {
        println("Creating record in local data source")
    }

    override fun update() {
        println("Updating record in local data source")
    }

    override fun read(): String {
        return "Reading record in local data source"
    }

    override fun delete() {
        println("Deleting record in local data source")
    }

}

class DataManager<T : DataSource>(private val dataSource: T) {
    companion object {
        const val CONNECTION_ERROR = "open connection before executing any curd operations"
    }

    private var isConnected = false;

    fun open() {
        isConnected = true
    }

    fun create(query: String) {
        check(isConnected) { CONNECTION_ERROR }
        dataSource.create()
    }

    fun update(query: String) {
        check(isConnected) { CONNECTION_ERROR }
        dataSource.update()
    }

    fun read(query: String): String {
        check(isConnected) { CONNECTION_ERROR }
        return dataSource.read()
    }

    fun delete(query: String) {
        check(isConnected) { CONNECTION_ERROR }
        dataSource.delete()
    }

    fun close() {
        isConnected = false
    }
}