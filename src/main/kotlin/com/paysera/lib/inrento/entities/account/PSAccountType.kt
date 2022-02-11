package com.paysera.lib.inrento.entities.account

import com.google.gson.annotations.SerializedName

enum class PSAccountType(val value: Int) {
    @SerializedName("1")
    PRIVATE_PERSON(1),
    @SerializedName("2")
    COMPANY(2)
}