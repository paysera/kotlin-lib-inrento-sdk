package com.paysera.lib.inrento.retrofit

import com.paysera.lib.inrento.entities.auth.PSAuthToken
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRefreshRequest
import kotlinx.coroutines.Deferred
import retrofit2.http.Body
import retrofit2.http.POST

interface NetworkAuthTokenApiClient {
    @POST("token/refresh")
    fun refreshToken(@Body authTokenRefreshRequest: PSAuthTokenRefreshRequest): Deferred<PSAuthToken>
}