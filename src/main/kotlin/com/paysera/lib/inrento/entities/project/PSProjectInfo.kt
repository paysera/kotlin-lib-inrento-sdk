package com.paysera.lib.inrento.entities.project

import com.google.gson.annotations.SerializedName

data class PSProjectInfo(
    @SerializedName("project_short") val project: PSProject?,
    val photos: List<String>,
    @SerializedName("description") val descriptionHtml: String,
    @SerializedName("risk_scoring") val riskScoring: List<PSRiskScoring>,
    val occupancy: List<PSPOccupancy>,
    @SerializedName("general_loan_terms") val generalLoanTermsDocumentId: Int?,
    @SerializedName("special_loan_terms") val specialLoanTermsDocumentId: Int
)