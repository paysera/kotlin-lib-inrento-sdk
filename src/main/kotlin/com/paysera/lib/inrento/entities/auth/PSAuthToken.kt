package com.paysera.lib.inrento.entities.auth

data class PSAuthToken(
    val authToken: String,
    val authTokenExpiresIn: Long,
    val refreshToken: String,
    val refreshTokenExpiresIn: Long,
    val expiresIn: Long
)