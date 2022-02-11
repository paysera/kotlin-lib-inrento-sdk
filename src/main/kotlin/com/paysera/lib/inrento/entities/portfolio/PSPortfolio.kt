package com.paysera.lib.inrento.entities.portfolio

import com.google.gson.annotations.SerializedName

data class PSPortfolio(
    val currency: String,
    val accountValue: String,
    val investedFunds: String,
    val outstandingPrincipal: String,
    val netAnnualReturn: String,
    val interest: String,
    val secondaryMarketTransactions: String,
    val serviceFee: String,
    val referralTotal: String,
    val totalProfit: String,
    @SerializedName("interest_in_30_days") val interestIn30Days: String,
    val investments: List<PSPortfolioInvestment>
)