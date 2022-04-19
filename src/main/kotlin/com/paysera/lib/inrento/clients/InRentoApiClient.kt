package com.paysera.lib.inrento.clients

import com.paysera.lib.common.retrofit.ApiRequestManager
import com.paysera.lib.common.retrofit.BaseApiClient
import com.paysera.lib.inrento.entities.account.PSAccount
import com.paysera.lib.inrento.entities.auth.PSAuthToken
import com.paysera.lib.inrento.entities.document.PSDocument
import com.paysera.lib.inrento.entities.portfolio.PSPortfolio
import com.paysera.lib.inrento.entities.project.PSProjectInfo
import com.paysera.lib.inrento.entities.project.PSProjectStatus
import com.paysera.lib.inrento.entities.project.PSProjectUpdates
import com.paysera.lib.inrento.entities.project.PSProjects
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRefreshRequest
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRequest
import com.paysera.lib.inrento.entities.requests.PSInvestRequest
import com.paysera.lib.inrento.entities.transaction.PSTransactions
import com.paysera.lib.inrento.retrofit.NetworkApiClient
import kotlinx.coroutines.Deferred
import retrofit2.Response

class InRentoApiClient(
    private val networkApiClient: NetworkApiClient,
    apiRequestManager: ApiRequestManager
) : BaseApiClient(apiRequestManager) {

    fun getAccount(): Deferred<PSAccount> {
        return networkApiClient.getAccount()
    }

    fun getPortfolio(
        page: Int,
        limit: Int
    ): Deferred<PSPortfolio> {
        return networkApiClient.getPortfolio(
            page = page,
            limit = limit
        )
    }

    fun getTransactions(
        page: Int,
        limit: Int
    ): Deferred<PSTransactions> {
        return networkApiClient.getTransactions(
            page = page,
            limit = limit
        )
    }

    fun getProjects(
        page: Int,
        limit: Int
    ): Deferred<PSProjects> {
        return networkApiClient.getProjects(
            page = page,
            limit = limit
        )
    }

    fun getProject(id: Int): Deferred<PSProjectInfo> {
        return networkApiClient.getProject(id)
    }

    fun getProjectStatus(id: Int): Deferred<PSProjectStatus> {
        return networkApiClient.getProjectStatus(id)
    }

    fun getProjectUpdates(id: Int): Deferred<PSProjectUpdates> {
        return networkApiClient.getProjectUpdates(id)
    }

    fun invest(investRequest: PSInvestRequest): Deferred<Response<Void>> {
        return networkApiClient.invest(investRequest)
    }

    fun confirmRiskAgreement(): Deferred<Response<Void>> {
        return networkApiClient.confirmRiskAgreement()
    }

    fun getDocument(id: Int): Deferred<PSDocument> {
        return networkApiClient.getDocument(id)
    }

    fun getToken(authTokenRequest: PSAuthTokenRequest): Deferred<PSAuthToken> {
        return networkApiClient.getToken(authTokenRequest)
    }

    fun refreshToken(authTokenRefreshRequest: PSAuthTokenRefreshRequest): Deferred<PSAuthToken> {
        return networkApiClient.refreshToken(authTokenRefreshRequest)
    }
}