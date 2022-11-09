package com.paysera.lib.inrento.clients

import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.inrento.entities.auth.PSAuthToken
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRefreshRequest
import com.paysera.lib.inrento.retrofit.NetworkAuthTokenApiClient
import kotlinx.coroutines.Deferred

class InRentoAuthTokenApiClient(
    private val networkAccessApiClient: NetworkAuthTokenApiClient,
    apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun refreshToken(authTokenRefreshRequest: PSAuthTokenRefreshRequest): Deferred<PSAuthToken> {
        return networkAccessApiClient.refreshToken(authTokenRefreshRequest)
    }
}