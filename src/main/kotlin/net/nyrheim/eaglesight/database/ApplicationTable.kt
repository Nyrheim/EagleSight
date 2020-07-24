package net.nyrheim.eaglesight.database

import org.jooq.impl.DSL.constraint
import org.jooq.impl.DSL.field
import org.jooq.impl.SQLDataType.INTEGER
import org.jooq.impl.SQLDataType.VARCHAR

class ApplicationTable(val database: Database) : Table {
    override fun create() {
        database.create.createTableIfNotExists("application")
            .column("id", INTEGER.identity(true))
            .column("minecraft_user", VARCHAR(16))
            .column("discord_user", VARCHAR(64))
            .column("age", INTEGER)
            .column("timezone", VARCHAR(8))
            .column("roleplay_experience", VARCHAR(2048))
            .column("where_from", VARCHAR(512))
            .constraints(
                constraint("pk_application").primaryKey("id")
            )
    }

    fun get(id: Int) {
        database.create
            .select(
                field("id"),
                field("minecraft_user"),
                field("discord_user"),
                field("age"),
                field("timezone"),
                field("roleplay_experience"),
                field("where_from")
            )
            .from("pk_application")
            .where(id.eq(field("id")))

    }

}