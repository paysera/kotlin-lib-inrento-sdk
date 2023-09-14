package com.paysera.lib.inrento.entities.document

data class PSProjectDocument(
    val name: String,
    val url: String,
    val language: String?,
    val categoryId: Int?,
    val categoryName: String?
)