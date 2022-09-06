package com.paysera.lib.inrento.retrofit

import com.paysera.lib.inrento.entities.auth.PSAuthToken
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRequest
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkAccessTokenApiClient {
    @POST("tokens")
    fun getTokens(@Body authTokenRequest: PSAuthTokenRequest): Deferred<PSAuthToken>
}