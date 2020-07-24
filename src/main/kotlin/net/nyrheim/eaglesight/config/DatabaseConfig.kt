package net.nyrheim.eaglesight.config

data class DatabaseConfig(
        val url: String = "jdbc:sqlite:vantage.db",
        val username: String? = null,
        val password: String? = null,
        val dialect: String = "SQLITE"
)