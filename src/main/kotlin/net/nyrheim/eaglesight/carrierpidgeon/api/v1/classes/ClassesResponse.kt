package net.nyrheim.eaglesight.carrierpidgeon.api.v1.classes

import net.nyrheim.eaglesight.carrierpidgeon.PidgeonGson.auto
import net.nyrheim.eaglesight.carrierpidgeon.`class`.PidgeonClass
import org.http4k.core.Body

data class ClassesResponse(val classes: List<PidgeonClass>) {
    companion object {
        val lens = Body.auto<ClassesResponse>().toLens()
    }
}