package net.nyrheim.eaglesight.carrierpidgeon.api.v1.items

import net.nyrheim.eaglesight.carrierpidgeon.PidgeonGson.auto
import net.nyrheim.eaglesight.carrierpidgeon.item.ItemType
import org.http4k.core.Body

class ItemsResponse(val items: List<ItemType>) {

    companion object {
        val lens = Body.auto<ItemsResponse>().toLens()
    }
}