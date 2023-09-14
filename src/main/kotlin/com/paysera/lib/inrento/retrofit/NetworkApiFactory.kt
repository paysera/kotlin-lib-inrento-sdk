package com.paysera.lib.inrento.retrofit

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.paysera.lib.common.interfaces.BaseApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.common.serializers.DateSerializer
import com.paysera.lib.common.serializers.MoneySerializer
import com.paysera.lib.inrento.clients.InRentoApiClient
import com.paysera.lib.inrento.entities.project.PSProject
import com.paysera.lib.inrento.serializers.ProjectDeserializer
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor
import org.joda.money.Money
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class NetworkApiFactory(
    baseUrl: String,
    userAgent: String?,
    credentials: BaseApiCredentials,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface,
    certificateInterceptor: Interceptor?
) : BaseApiFactory<InRentoApiClient>(
    baseUrl = baseUrl,
    userAgent = userAgent,
    credentials = credentials,
    timeout = timeout,
    httpLoggingInterceptorLevel = httpLoggingInterceptorLevel,
    errorLogger = errorLogger,
    certificateInterceptor = certificateInterceptor
) {

    override fun createClient(tokenRefresher: TokenRefresherInterface?): InRentoApiClient {
        createRetrofit(tokenRefresher).apply {
            return InRentoApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }

    override fun createGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create(
            GsonBuilder().apply {
                setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                registerTypeAdapter(Money::class.java, MoneySerializer())
                registerTypeAdapter(Date::class.java, DateSerializer())
                registerTypeAdapter(PSProject::class.java, ProjectDeserializer())
            }.create()
        )
    }
}