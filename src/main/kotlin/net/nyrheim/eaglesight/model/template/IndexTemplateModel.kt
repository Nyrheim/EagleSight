package net.nyrheim.eaglesight.model.template

import org.http4k.template.ViewModel

class IndexTemplateModel(
    val baseUrl: String
) : ViewModel {
    override fun template() = "index"
}