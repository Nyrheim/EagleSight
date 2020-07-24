package net.nyrheim.eaglesight.model.template

import org.http4k.template.ViewModel

class ApplyCharacterTemplateModel(val baseUrl: String) : ViewModel {
    override fun template() = "apply_character"
}