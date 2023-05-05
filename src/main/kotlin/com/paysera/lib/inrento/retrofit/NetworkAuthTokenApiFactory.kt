package com.paysera.lib.inrento.retrofit

import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.common.retrofit.BaseApiFactory
import com.paysera.lib.inrento.clients.InRentoAuthTokenApiClient
import okhttp3.Interceptor
import okhttp3.logging.HttpLoggingInterceptor

class NetworkAuthTokenApiFactory(
    baseUrl: String,
    userAgent: String?,
    timeout: Long? = null,
    httpLoggingInterceptorLevel: HttpLoggingInterceptor.Level = HttpLoggingInterceptor.Level.BASIC,
    errorLogger: ErrorLoggerInterface,
    certificateInterceptor: Interceptor?
) : BaseApiFactory<InRentoAuthTokenApiClient>(
    baseUrl = baseUrl,
    userAgent = userAgent,
    credentials = null,
    timeout = timeout,
    httpLoggingInterceptorLevel = httpLoggingInterceptorLevel,
    errorLogger = errorLogger,
    certificateInterceptor = certificateInterceptor
) {

    override fun createClient(tokenRefresher: TokenRefresherInterface?): InRentoAuthTokenApiClient {
        createRetrofit(tokenRefresher).apply {
            return InRentoAuthTokenApiClient(
                retrofit.create(NetworkAuthTokenApiClient::class.java),
                apiRequestManager
            )
        }
    }
}