package com.paysera.lib.inrento.entities.account

import com.google.gson.annotations.SerializedName

data class PSAccount(
    @SerializedName("user_id") val id: Int,
    val accountType: PSAccountType,
    val email: String,
    val name: String,
    val surname: String,
    val companyName: String? = null,
    val invitedUsersCount: Int,
    @SerializedName("verified") val isVerified: Boolean,
    val showBeforeInvestQuestionnaire: Boolean,
    val showRiskAgreement: Boolean
)