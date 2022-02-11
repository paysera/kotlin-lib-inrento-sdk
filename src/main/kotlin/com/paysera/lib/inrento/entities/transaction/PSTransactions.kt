package com.paysera.lib.inrento.entities.transaction

import com.google.gson.annotations.SerializedName

data class PSTransactions(
    @SerializedName("total_transactions") val transactionCount: Int? = null,
    val transactions: List<PSTransaction>? = null,
)