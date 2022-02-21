package com.paysera.lib.inrento.retrofit

import com.paysera.lib.common.interfaces.BaseApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.inrento.clients.InRentoApiClient
import okhttp3.logging.HttpLoggingInterceptor

class NetworkApiFactory(
    baseUrl: String,
    locale: String?,
    userAgent: String?,
    credentials: BaseApiCredentials,
    certifiedHosts: List<String> = emptyList(),
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface
) : BaseApiFactory<InRentoApiClient>(
    baseUrl = baseUrl,
    locale = locale,
    userAgent = userAgent,
    credentials = credentials,
    certifiedHosts = certifiedHosts,
    timeout = timeout,
    httpLoggingInterceptorLevel = httpLoggingInterceptorLevel,
    errorLogger = errorLogger
) {

    override fun createClient(tokenRefresher: TokenRefresherInterface?): InRentoApiClient {
        createRetrofit(tokenRefresher).apply {
            return InRentoApiClient(
                retrofit.create(NetworkApiClient::class.java),
                apiRequestManager
            )
        }
    }
}