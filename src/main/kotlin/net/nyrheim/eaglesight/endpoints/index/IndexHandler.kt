package net.nyrheim.eaglesight.endpoints.index

import net.nyrheim.eaglesight.model.template.IndexTemplateModel
import org.http4k.core.Body
import org.http4k.core.ContentType.Companion.TEXT_HTML
import org.http4k.core.Request
import org.http4k.core.Response
import org.http4k.core.Status.Companion.OK
import org.http4k.core.with
import org.http4k.template.TemplateRenderer
import org.http4k.template.viewModel

class IndexHandler(
    val baseUrl: String,
    renderer: TemplateRenderer
) {

    val viewLens = Body.viewModel(renderer, TEXT_HTML).toLens()

    fun get(request: Request): Response {
        return Response(OK).with(viewLens of IndexTemplateModel(baseUrl))
    }

}