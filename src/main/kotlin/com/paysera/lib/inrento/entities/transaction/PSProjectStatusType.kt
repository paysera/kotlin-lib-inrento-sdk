package com.paysera.lib.inrento.entities.transaction

import com.google.gson.annotations.SerializedName

enum class PSProjectStatusType(val value: Int) {
    @SerializedName("0")
    NOT_AVAILABLE(0),
    @SerializedName("1")
    FUNDING(1),
    @SerializedName("2")
    FUNDED(2),
    @SerializedName("3")
    RETURNED(3)
}