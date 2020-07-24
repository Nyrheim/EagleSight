package net.nyrheim.eaglesight.carrierpidgeon.api.v1.tokenexchange

import net.nyrheim.eaglesight.carrierpidgeon.PidgeonGson.auto
import org.http4k.core.Body

data class TokenExchangeRequest(val username: String) {
    companion object {
        val lens = Body.auto<TokenExchangeRequest>().toLens()
    }
}