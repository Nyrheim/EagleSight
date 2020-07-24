package net.nyrheim.eaglesight.database

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import net.nyrheim.eaglesight.config.DatabaseConfig
import org.jooq.DSLContext
import org.jooq.SQLDialect
import org.jooq.conf.Settings
import org.jooq.impl.DSL
import kotlin.reflect.KClass

class Database(private val config: DatabaseConfig) {

    private val dataSource: HikariDataSource
    private val settings = Settings().withRenderSchema(false)
    private val tables = listOf<Table>(
        ApplicationTable(this)
    )

    val create: DSLContext
        get() = DSL.using(dataSource, SQLDialect.valueOf(config.dialect))

    init {
        val url = config.url
        val username = config.username
        val password = config.password
        val hikariConfig = HikariConfig()
        hikariConfig.jdbcUrl = url
        if (username != null) {
            hikariConfig.username = username
        }
        if (password != null) {
            hikariConfig.password = password
        }
        dataSource = HikariDataSource(hikariConfig)
        create()
    }

    fun create() {
        tables.forEach(Table::create)
    }

    fun <T: Table> table(type: KClass<out T>): T {
        return tables.first { type.isInstance(it) } as T
    }

}