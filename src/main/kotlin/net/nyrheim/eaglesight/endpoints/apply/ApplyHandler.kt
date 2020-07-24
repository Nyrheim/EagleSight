package net.nyrheim.eaglesight.endpoints.apply

import net.nyrheim.eaglesight.model.template.ApplyCharacterTemplateModel
import net.nyrheim.eaglesight.model.template.ApplyPlayerTemplateModel
import org.http4k.core.*
import org.http4k.core.Status.Companion.OK
import org.http4k.core.cookie.Cookie
import org.http4k.core.cookie.cookie
import org.http4k.template.TemplateRenderer
import org.http4k.template.viewModel

class ApplyHandler(val baseUrl: String, renderer: TemplateRenderer) {

    val viewLens = Body.viewModel(renderer, ContentType.TEXT_HTML).toLens()

    fun get(request: Request): Response {
        return Response(OK)
            .with(viewLens of ApplyPlayerTemplateModel(baseUrl))
    }

    fun postPlayer(request: Request): Response {
        return Response(OK)
            .cookie(Cookie(""))
            .with(viewLens of ApplyCharacterTemplateModel(baseUrl))
    }
}