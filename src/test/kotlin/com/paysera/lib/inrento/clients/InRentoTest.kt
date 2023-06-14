package com.paysera.lib.inrento.clients

import com.paysera.lib.common.exceptions.ApiError
import com.paysera.lib.inrento.entities.questionnaire.QuestionnaireAnswersRequest
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRefreshRequest
import com.paysera.lib.inrento.entities.requests.PSAuthTokenRequest
import com.paysera.lib.inrento.entities.requests.PSInvestRequest
import com.paysera.lib.inrento.runCatchingBlocking
import org.junit.jupiter.api.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation::class)
internal class InRentoTest : BaseTest() {

    @Test
    @Order(1)
    fun getToken() {
        val authTokenResponse = accessAuthTokenApiClient.getTokens(
            PSAuthTokenRequest(-1)
        ).runCatchingBlocking()
        val authTokenRefreshResponse = authAuthTokenApiClient.refreshToken(
            PSAuthTokenRefreshRequest(authTokenResponse.getOrNull()?.refreshToken!!)
        ).runCatchingBlocking()
        setUpRefreshingApiCalls(authTokenRefreshResponse.getOrNull()?.authToken)
        assert(authTokenResponse.isSuccess && authTokenRefreshResponse.isSuccess)
    }

    @Test
    fun getAccount() {
        val response = apiClient.getAccount().runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getProjects() {
        val response = apiClient.getProjects(0, 10).runCatchingBlocking()
        assert(response.isSuccess)
    }

    @Test
    fun getProject() {
        val response = apiClient.getProject(337).runCatchingBlocking()
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
        assert(response.isSuccess || (response.exceptionOrNull() as? ApiError)?.error == "INVESTMENTS_CLOSED")
    }

    @Test
    fun confirmRiskAgreement() {
        val response = apiClient.confirmRiskAgreement().runCatchingBlocking()
        val error = (response.exceptionOrNull() as? ApiError)?.error
        assert(response.isSuccess || error == "USER_ALREADY_CONFIRMED_RISK_AGREEMENT")
    }

    @Test
    fun saveQuestionnaire() {
        val questionnaireAnswersRequest = QuestionnaireAnswersRequest(
            "finansai",
            "pagrindinis",
            LocalDate.now().minusYears(18).format(DateTimeFormatter.ofPattern("yyyy-dd-MM")),
            "iki 1 metų",
            "taip",
            listOf("Nekilnojamo turto nuomą"),
            listOf("bet kokios formos paskolos kitiems asmenims (paskolos sutartys, vekseliai ir kt.)"),
            "nesu investavęs praeityje",
            "mažiau nei 6 mėnesius",
            "nuo 6 mėnesių iki 2 metų",
            "taip",
            "Detailed answer"
        )
        val response = apiClient.saveQuestionnaire(questionnaireAnswersRequest).runCatchingBlocking()
        val error = (response.exceptionOrNull() as? ApiError)?.error
        assert(response.isSuccess || error == "USER_ANSWER_ALREADY_EXISTS")
    }
}