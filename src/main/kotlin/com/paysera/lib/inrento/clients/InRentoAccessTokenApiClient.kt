package com.paysera.lib.inrento.clients

import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.inrento.entities.auth.PSAuthToken
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRequest
import com.paysera.lib.inrento.retrofit.NetworkAccessTokenApiClient
import kotlinx.coroutines.Deferred

class InRentoAccessTokenApiClient(
    private val networkAccessApiClient: NetworkAccessTokenApiClient,
    apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun getTokens(authTokenRequest: PSAuthTokenRequest): Deferred<PSAuthToken> {
        return networkAccessApiClient.getTokens(authTokenRequest)
    }
}