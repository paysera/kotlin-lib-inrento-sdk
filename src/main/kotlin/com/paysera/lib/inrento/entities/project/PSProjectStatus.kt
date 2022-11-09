package com.paysera.lib.inrento.entities.project

import com.google.gson.annotations.SerializedName

data class PSProjectStatus(
    @SerializedName("project_status") val status: Int,
    val currency: String,
    val collectedFunds: String,
    val investorsCount: Int,
    val userInvestments: String,
    val userOutstandingPrincipal: String
)