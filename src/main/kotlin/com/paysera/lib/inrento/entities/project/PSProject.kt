package com.paysera.lib.inrento.entities.project

import com.google.gson.annotations.SerializedName
import com.paysera.lib.inrento.entities.document.PSProjectDocument
import org.joda.money.Money
import java.util.*

data class PSProject(
    val id: Int,
    val name: String,
    val status: Int?,
    val country: String?,
    val city: String?,
    val address: String?,
    val latitude: Double?,
    val longitude: Double?,
    val fundingAmount: Money?,
    val collectedFunds: Money?,
    val investorsCount: Int,
    val annualYield: String,
    val additionalAnnualYield: String?,
    @SerializedName("yield_param1_name") val yieldName: String,
    @SerializedName("yield_param1_value") val yieldValue: String,
    val fixedCapitalGain: String?,
    val profitShareCapitalGain: String?,
    val termInMonths: Int?,
    val term: Int?,
    val termDisplay: String?,
    val realReturn: String?,
    val realTerm: Int?,
    @SerializedName("date_end_investments") val endInvestmentsDate: Date?,
    val principalReturnDate: Date?,
    val investmentType: Int?,
    val investmentTypeName: String?,
    val propertyType: Int?,
    val propertyTypeName: String?,
    val mortgageRank: Int?,
    val mortgageRankName: String?,
    val mainPhotoURL: String?,
    val riskScoringValue: String?,
    val interestDistribution: String?,
    val updates: List<PSProjectUpdate>?,
    val documents: List<PSProjectDocument>?,
    val capitalGains: PSProjectCapitalGains?,
    val reasonsToInvest: List<String>?,
    val financialTerms: String?,
    val projectOwner: PSProjectOwner?,
    val generalLoanTermsDocumentId: Int?,
    val specialLoanTermsDocumentId: Int?,
    val descriptionHtml: String?,
    val riskScoring: List<PSRiskScoring>? = null,
    val occupancy: List<PSPProjectOccupancy>? = null,
    val photos: List<String>? = null
)