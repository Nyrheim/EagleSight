package net.nyrheim.eaglesight.config

data class Config(
    val server: ServerConfig = ServerConfig(),
    val database: DatabaseConfig = DatabaseConfig(),
    val carrierPidgeon: CarrierPidgeonConfig = CarrierPidgeonConfig()
)