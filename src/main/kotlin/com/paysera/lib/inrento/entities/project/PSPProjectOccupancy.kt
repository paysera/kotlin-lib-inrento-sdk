package com.paysera.lib.inrento.entities.project

import com.google.gson.annotations.SerializedName

data class PSPProjectOccupancy(
    val occupancy: Int,
    @SerializedName("arr") val annualReturnRate: String,
    @SerializedName("additional_arr") val additionalAnnualReturnRate: String?
)