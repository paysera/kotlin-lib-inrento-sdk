package com.paysera.lib.inrento.entities.project

import com.google.gson.annotations.SerializedName

data class PSProjects(
    @SerializedName("total_projects") val totalProjectCount: Int,
    val projects: List<PSProject>
)