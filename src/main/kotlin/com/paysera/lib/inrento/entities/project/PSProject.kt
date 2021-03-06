package com.paysera.lib.inrento.entities.project

import com.google.gson.annotations.SerializedName

data class PSProject(
    val id: Int,
    val name: String,
    val status: PSProjectStatusType,
    val country: String?,
    val city: String?,
    val address: String?,
    val currency: String?,
    val fundingAmount: String,
    val collectedFunds: String,
    val investorsCount: Int,
    val annualYield: String,
    val additionalAnnualYield: String?,
    @SerializedName("yield_param1_name") val yieldName: String,
    @SerializedName("yield_param1_value") val yieldValue: String,
    val termInMonths: Int,
    val term: String?,
    val termDisplay: String?,
    val realReturn: String?,
    val realTerm: Int?,
    @SerializedName("date_end_investments") val endInvestmentsDate: Int,
    val principalReturnDate: Int?,
    val investmentType: Int?,
    val investmentTypeName: String?,
    val propertyType: Int?,
    val propertyTypeName: String?,
    val mortgageRank: Int?,
    val mortgageRankName: String?,
    @SerializedName("photo") val mainPhotoURL: String?,
    val riskScoringValue: String?,
    val interestDistribution: String?
)