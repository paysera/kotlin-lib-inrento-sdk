package com.paysera.lib.inrento.entities.portfolio

import com.google.gson.annotations.SerializedName
import java.util.*

data class PSPortfolioInvestment(
    @SerializedName("investment_id") val id: Int,
    val date: Date,
    val projectId: Int,
    val projectName: String,
    val projectMainPhotoUrl: String? = null,
    val currency: String,
    val investedFunds: String,
    val receivedDividends: String,
    val receivedPrincipal: String,
    val outstandingPrincipal: String,
)