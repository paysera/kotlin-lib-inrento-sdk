package com.paysera.lib.inrento.extensions

import com.google.gson.JsonElement
import com.google.gson.JsonNull
import com.google.gson.JsonObject

fun JsonObject.getJsonElementOrNull(memberName: String): JsonElement? {
    return if (has(memberName) && get(memberName) != JsonNull.INSTANCE) {
        get(memberName)
    } else {
        null
    }
}