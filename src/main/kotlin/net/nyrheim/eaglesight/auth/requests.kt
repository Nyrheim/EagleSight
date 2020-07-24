package net.nyrheim.eaglesight.auth

import org.http4k.core.Request
import org.http4k.core.cookie.cookie

fun Request.applicationId(authenticator: Authenticator) =
        cookie("jwt")
                ?.let { authenticator.verify(it.value) }
                ?.body
                ?.subject
                ?.toIntOrNull()