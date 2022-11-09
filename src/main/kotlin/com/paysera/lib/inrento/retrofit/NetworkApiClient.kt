package com.paysera.lib.inrento.retrofit

import com.paysera.lib.inrento.entities.account.PSAccount
import com.paysera.lib.inrento.entities.portfolio.PSPortfolio
import com.paysera.lib.inrento.entities.project.PSProjectInfo
import com.paysera.lib.inrento.entities.project.PSProjectStatus
import com.paysera.lib.inrento.entities.project.PSProjects
import com.paysera.lib.inrento.entities.questionnaire.QuestionnaireAnswersRequest
import com.paysera.lib.inrento.entities.requests.PSInvestRequest
import com.paysera.lib.inrento.entities.transaction.PSTransactions
import kotlinx.coroutines.Deferred
import retrofit2.Response
import retrofit2.http.*

interface NetworkApiClient {

    @GET("account")
    fun getAccount(): Deferred<PSAccount>

    @GET("portfolio")
    fun getPortfolio(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Deferred<PSPortfolio>

    @GET("transactions")
    fun getTransactions(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Deferred<PSTransactions>

    @GET("projects")
    fun getProjects(
        @Query("page") page: Int,
        @Query("limit") limit: Int
    ): Deferred<PSProjects>

    @GET("project/{id}")
    fun getProject(@Path("id") id: Int): Deferred<PSProjectInfo>

    @GET("project/{id}/stats")
    fun getProjectStatus(@Path("id") id: Int): Deferred<PSProjectStatus>

    @POST("invest")
    fun invest(@Body investRequest: PSInvestRequest): Deferred<Response<Void>>

    @POST("risk_agreement")
    fun confirmRiskAgreement(): Deferred<Response<Void>>

    @POST("questionnaire")
    fun saveQuestionnaire(
        @Body questionnaireAnswersRequest: QuestionnaireAnswersRequest
    ): Deferred<Response<Void>>
}