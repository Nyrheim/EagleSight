package net.nyrheim.eaglesight.carrierpidgeon.api.v1.races

import net.nyrheim.eaglesight.carrierpidgeon.PidgeonGson.auto
import net.nyrheim.eaglesight.carrierpidgeon.race.Race
import org.http4k.core.Body

data class RacesResponse(val races: List<Race>) {
    companion object {
        val lens = Body.auto<RacesResponse>().toLens()
    }
}