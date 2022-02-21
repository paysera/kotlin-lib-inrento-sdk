package com.paysera.lib.inrento.entities.project

import com.google.gson.annotations.SerializedName

enum class PSProjectStatusType(value: Int) {
    @SerializedName("1")
    FUNDING(1),
    @SerializedName("2")
    DONE(2),
    @SerializedName("3")
    RETURNED(3)
}