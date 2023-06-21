package com.paysera.lib.inrento.entities.project

data class PSInvestmentEarns(
    val annualYield: String,
    val additionalAnnualYield: String,
    val earn: String,
    val earnAdditional: String,
    val totalExpectedEarnings: String,
    val totalExpectedEarningsAdditional: String,
    val capitalGainPercentage: String?,
    val projectId: String
)