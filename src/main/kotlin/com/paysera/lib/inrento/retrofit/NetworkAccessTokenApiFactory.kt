package com.paysera.lib.inrento.retrofit

import com.paysera.lib.common.entities.CustomApiCredentials
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.inrento.clients.InRentoAccessTokenApiClient
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class NetworkAccessTokenApiFactory(
    baseUrl: String,
    locale: String?,
    userAgent: String?,
    credentials: CustomApiCredentials?,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface,
    certificateInterceptor: Interceptor?
) : BaseApiFactory<InRentoAccessTokenApiClient>(
    baseUrl = baseUrl,
    locale = locale,
    userAgent = userAgent,
    credentials = credentials,
    timeout = timeout,
    httpLoggingInterceptorLevel = httpLoggingInterceptorLevel,
    errorLogger = errorLogger,
    certificateInterceptor = certificateInterceptor
) {

    override fun createClient(tokenRefresher: TokenRefresherInterface?): InRentoAccessTokenApiClient {
        createRetrofit(tokenRefresher).apply {
            return InRentoAccessTokenApiClient(
                retrofit.create(NetworkAccessTokenApiClient::class.java),
                apiRequestManager
            )
        }
    }
}