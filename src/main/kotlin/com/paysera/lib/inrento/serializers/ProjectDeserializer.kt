package com.paysera.lib.inrento.serializers

import com.google.gson.JsonDeserializationContext
import com.google.gson.JsonDeserializer
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.paysera.lib.inrento.entities.document.PSProjectDocument
import com.paysera.lib.inrento.entities.project.*
import com.paysera.lib.inrento.extensions.getJsonElementOrNull
import org.joda.money.CurrencyUnit
import org.joda.money.Money
import java.lang.reflect.Type
import java.util.*

class ProjectDeserializer : JsonDeserializer<PSProject?> {

    override fun deserialize(
        json: JsonElement?,
        typeOfT: Type?,
        context: JsonDeserializationContext?
    ): PSProject? {
        val jsonObject = json?.asJsonObject ?: return null
        val project = if (jsonObject.has("project_short")) {
            val projectShort = jsonObject.getAsJsonObject("project_short")
            getProject(projectShort, context, jsonObject)
        } else {
            getProject(jsonObject, context)
        }
        return project
    }

    private fun getProject(
        project: JsonObject,
        context: JsonDeserializationContext?,
        parentObject: JsonObject? = null
    ): PSProject {
        val currency = project.getJsonElementOrNull("currency")?.asString
        return PSProject(
            id = project.get("id").asInt,
            name = project.get("name").asString,
            status = project.get("status").asInt,
            country = project.getJsonElementOrNull("country")?.asString,
            city = project.getJsonElementOrNull("city")?.asString,
            address = project.getJsonElementOrNull("address")?.asString,
            latitude = project.getJsonElementOrNull("latitude")?.asDouble,
            longitude = project.getJsonElementOrNull("longitude")?.asDouble,
            fundingAmount = project.getJsonElementOrNull("funding_amount")
                ?.asBigDecimal
                ?.let {
                    Money.of(CurrencyUnit.of(currency), it)
                },
            collectedFunds = project.getJsonElementOrNull("collected_funds")
                ?.asBigDecimal
                ?.let {
                    Money.of(CurrencyUnit.of(currency), it)
                },
            investorsCount = project.get("investors_count").asInt,
            annualYield = project.get("annual_yield").asString,
            additionalAnnualYield = project.getJsonElementOrNull("additional_annual_yield")?.asString,
            yieldName = project.get("yield_param1_name").asString,
            yieldValue = project.get("yield_param1_value").asString,
            termInMonths = project.getJsonElementOrNull("term_in_months")?.asInt,
            term = project.getJsonElementOrNull("term")?.asInt,
            termDisplay = project.getJsonElementOrNull("term_display")?.asString,
            realReturn = project.getJsonElementOrNull("real_return")?.asString,
            realTerm = project.getJsonElementOrNull("real_term")?.asInt,
            endInvestmentsDate = context?.deserialize<Date>(project.get("date_end_investments"), Date::class.java),
            principalReturnDate = context?.deserialize<Date>(
                project.get("date_principal_return"),
                Date::class.java
            ),
            investmentType = project.getJsonElementOrNull("investment_type")?.asInt,
            investmentTypeName = project.getJsonElementOrNull("investment_type_name")?.asString,
            propertyType = project.getJsonElementOrNull("property_type")?.asInt,
            propertyTypeName = project.getJsonElementOrNull("property_type_name")?.asString,
            mortgageRank = project.getJsonElementOrNull("mortgage_rank")?.asInt,
            mortgageRankName = project.getJsonElementOrNull("mortgage_rank_name")?.asString,
            mainPhotoURL = project.getJsonElementOrNull("photo")?.asString,
            riskScoringValue = project.getJsonElementOrNull("risk_scoring_value")?.asString,
            interestDistribution = project.getJsonElementOrNull("interest_distribution")?.asString,
            updates = project.getJsonElementOrNull("updates")?.let {
                return@let it.asJsonArray.mapNotNull { update ->
                    context?.deserialize<PSProjectUpdate>(update, PSProjectUpdate::class.java)
                }
            },
            documents = project.getJsonElementOrNull("documents")?.let {
                return@let it.asJsonArray.mapNotNull { document ->
                    context?.deserialize<PSProjectDocument>(document, PSProjectDocument::class.java)
                }
            },
            capitalGains = context?.deserialize<PSProjectCapitalGains>(
                project.get("capital_gains"),
                PSProjectCapitalGains::class.java
            ),
            reasonsToInvest = project.getJsonElementOrNull("reasons_to_invest")?.let {
                return@let it.asJsonArray.mapNotNull { reasonsToInvest ->
                    context?.deserialize<String>(reasonsToInvest, String::class.java)
                }
            },
            financialTerms = project.getJsonElementOrNull("financial_terms")?.asString,
            projectOwner = context?.deserialize<PSProjectOwner>(
                project.get("project_owner"),
                PSProjectOwner::class.java
            ),
            descriptionHtml = project.getJsonElementOrNull("description")?.asString,
            generalLoanTermsDocumentId = parentObject?.getJsonElementOrNull("general_loan_terms")?.asInt,
            specialLoanTermsDocumentId = parentObject?.getJsonElementOrNull("special_loan_terms")?.asInt,
            riskScoring = parentObject?.getJsonElementOrNull("risk_scoring")?.let {
                return@let it.asJsonArray.mapNotNull { riskScoring ->
                    context?.deserialize<PSRiskScoring>(riskScoring, PSRiskScoring::class.java)
                }
            },
            occupancy = parentObject?.getJsonElementOrNull("occupancy")?.let {
                return@let it.asJsonArray.mapNotNull { occupancy ->
                    context?.deserialize<PSPProjectOccupancy>(occupancy, PSPProjectOccupancy::class.java)
                }
            },
            photos = parentObject?.getJsonElementOrNull("photos")?.let {
                return@let it.asJsonArray.mapNotNull { photo ->
                    context?.deserialize<String>(photo, String::class.java)
                }
            }
        )
    }
}