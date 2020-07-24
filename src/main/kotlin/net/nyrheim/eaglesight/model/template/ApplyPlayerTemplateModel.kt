package net.nyrheim.eaglesight.model.template

import org.http4k.template.ViewModel

class ApplyPlayerTemplateModel(
    val baseUrl: String
) : ViewModel {
    override fun template() = "apply_player"
}