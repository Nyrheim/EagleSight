package net.nyrheim.eaglesight

import com.google.gson.GsonBuilder
import net.nyrheim.eaglesight.carrierpidgeon.CarrierPidgeonClient
import net.nyrheim.eaglesight.config.Config
import net.nyrheim.eaglesight.config.InvalidConfigException
import net.nyrheim.eaglesight.endpoints.apply.ApplyHandler
import net.nyrheim.eaglesight.endpoints.index.IndexHandler
import org.http4k.core.Method.GET
import org.http4k.core.Method.POST
import org.http4k.routing.ResourceLoader.Companion.Classpath
import org.http4k.routing.bind
import org.http4k.routing.routes
import org.http4k.routing.static
import org.http4k.server.Jetty
import org.http4k.server.asServer
import org.http4k.template.PebbleTemplates
import java.io.File
import kotlin.text.Charsets.UTF_8

fun main() {
    val gson = GsonBuilder().setPrettyPrinting().create()
    val configFile = File("./config.json")
    if (configFile.isDirectory) {
        throw InvalidConfigException("Config file exists, but is a directory. Please remove the directory named config.json")
    }
    if (!configFile.exists()) {
        configFile.writeText(gson.toJson(Config()))
    }
    val config = try {
        gson.fromJson(configFile.reader(UTF_8), Config::class.java)
    } catch (exception: Exception) {
        throw InvalidConfigException("Failed to parse config file", exception)
    }

    val database = Database(config.database)

    val carrierPidgeon = CarrierPidgeonClient(config.carrierPidgeon)
    val renderer = PebbleTemplates().CachingClasspath("templates")

    val indexHandler = IndexHandler(config.server.baseUrl, renderer)
    val applyHandler = ApplyHandler(config.server.baseUrl, renderer)

    val app = routes(
        "/" bind GET to indexHandler::get,
        "/apply" bind GET to applyHandler::get,
        "/apply/character" bind POST to applyHandler::postPlayer,
        "/static" bind static(Classpath("/static"))
    )

    app.asServer(Jetty(config.server.port)).start()
}