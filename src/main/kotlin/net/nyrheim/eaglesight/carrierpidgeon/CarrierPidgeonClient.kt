package net.nyrheim.eaglesight.carrierpidgeon

import net.nyrheim.eaglesight.carrierpidgeon.`class`.PidgeonClass
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.character.CharacterPatchRequest
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.character.CharacterPostRequest
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.character.CharacterPutRequest
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.character.CharacterResponse
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.classes.ClassesResponse
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.items.ItemsResponse
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.login.LoginRequest
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.login.LoginResponse
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.races.RacesResponse
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.tokenexchange.TokenExchangeRequest
import net.nyrheim.eaglesight.carrierpidgeon.api.v1.tokenexchange.TokenExchangeResponse
import net.nyrheim.eaglesight.carrierpidgeon.character.PidgeonCharacter
import net.nyrheim.eaglesight.carrierpidgeon.item.ItemType
import net.nyrheim.eaglesight.carrierpidgeon.race.Race
import net.nyrheim.eaglesight.config.CarrierPidgeonConfig
import org.http4k.client.ApacheClient
import org.http4k.core.Method.*
import org.http4k.core.Request
import org.http4k.core.Status.Companion.CREATED
import org.http4k.core.Status.Companion.NO_CONTENT
import org.http4k.core.Status.Companion.OK
import org.http4k.core.with

class CarrierPidgeonClient(val config: CarrierPidgeonConfig) {

    private val http = ApacheClient()

    fun login(username: String, password: String): String? {
        val response = http(Request(POST, "${config.url}/api/v1/login")
            .with(LoginRequest.lens of LoginRequest(username, password)))
        if (response.status == OK) return LoginResponse.lens(response).jwt
        return null
    }

    fun tokenExchange(username: String): String? {
        val response = http(Request(POST, "${config.url}/api/v1/tokenexchange")
            .with(TokenExchangeRequest.lens of TokenExchangeRequest(username)))
        if (response.status == OK) return TokenExchangeResponse.lens(response).jwt
        return null
    }

    fun getCharacter(id: Int): PidgeonCharacter? {
        val response = http(Request(GET, "${config.url}/api/v1/character/$id"))
        if (response.status == OK) return CharacterResponse.lens(response).toCharacter()
        return null
    }

    fun createCharacter(request: CharacterPostRequest): PidgeonCharacter? {
        val response = http(Request(POST, "${config.url}/api/v1/character")
            .with(CharacterPostRequest.lens of request))
        if (response.status == CREATED) return CharacterResponse.lens(response).toCharacter()
        return null
    }

    fun patchCharacter(id: Int, request: CharacterPatchRequest): Boolean {
        val response = http(Request(PATCH, "${config.url}/api/v1/character/$id")
            .with(CharacterPatchRequest.lens of request))
        return response.status == NO_CONTENT
    }

    fun putCharacter(id: Int, request: CharacterPutRequest): Boolean {
        val response = http(Request(PUT, "${config.url}/api/v1/character/$id")
            .with(CharacterPutRequest.lens of request))
        return response.status == NO_CONTENT
    }

    fun getItems(): List<ItemType> {
        val response = http(Request(GET, "${config.url}/api/v1/items"))
        return ItemsResponse.lens(response).items
    }

    fun getClasses(): List<PidgeonClass> {
        val response = http(Request(GET, "${config.url}/api/v1/classes"))
        return ClassesResponse.lens(response).classes
    }

    fun getRaces(): List<Race> {
        val response = http(Request(GET, "${config.url}/api/v1/races"))
        return RacesResponse.lens(response).races
    }

}