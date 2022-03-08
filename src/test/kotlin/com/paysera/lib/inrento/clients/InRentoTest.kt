package com.paysera.lib.inrento.clients

import com.paysera.lib.common.exceptions.ApiError
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRefreshRequest
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRequest
import com.paysera.lib.inrento.entities.requests.PSInvestRequest
import com.paysera.lib.inrento.runCatchingBlocking
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestInstance

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
internal class InRentoTest : BaseTest() {

    @Test
    fun getToken() {
        val authTokenResponse = apiClient.getToken(PSAuthTokenRequest("729511"))
            .runCatchingBlocking()
        val authTokenRefreshResponse= apiClient.refreshToken(PSAuthTokenRefreshRequest(authTokenResponse.getOrNull()?.refreshToken!!))
            .runCatchingBlocking()
        assert(authTokenResponse.isSuccess && authTokenRefreshResponse.isSuccess)
    }

    @Test
    fun getAccount() {
        val response = apiClient.getAccount()
            .runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getPortfolio() {
        val response = apiClient.getPortfolio(0, 10)
            .runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getTransactions() {
        val response = apiClient.getTransactions(0, 10)
            .runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getProjects() {
        val response = apiClient.getProjects(0, 10)
            .runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getProject() {
        val response = apiClient.getProject(337)
            .runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getProjectStatus() {
        val response = apiClient.getProjectStatus(342)
            .runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun invest() {
        val response = apiClient.invest(
            PSInvestRequest(
                projectId = 342,
                amount = 1
            )
        ).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun confirmRiskAgreement() {
        val response = apiClient.confirmRiskAgreement()
            .runCatchingBlocking()
        val error = (response.exceptionOrNull() as? ApiError)?.error
        assert(response.isSuccess || error == "USER_ALREADY_CONFIRMED_RISK_AGREEMENT")
    }

    @Test
    fun getDocument() {
        val response = apiClient.getDocument(17)
            .runCatchingBlocking()
        assert(response.isSuccess)
    }
}