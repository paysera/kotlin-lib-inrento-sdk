package com.paysera.lib.inrento.entities.transaction

import com.google.gson.annotations.SerializedName
import java.util.*

data class PSTransaction(
    @SerializedName("transaction_id") val id: Int,
    val date: Date,
    val type: String,
    val amount: String,
    @SerializedName("sm_price") val secondaryMarketPrice: String? = null,
    val currency: String,
    val projectName: String? = null,
    val projectStatus: PSProjectStatusType? = null
)