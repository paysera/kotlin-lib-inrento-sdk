package com.paysera.lib.inrento.clients

import com.paysera.lib.common.entities.CustomApiCredentials
import com.paysera.lib.common.entities.InRentoApiCredentials
import com.paysera.lib.common.exceptions.ApiError
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.inrento.retrofit.NetworkApiFactory
import com.paysera.lib.inrento.retrofit.NetworkAccessTokenApiFactory
import com.paysera.lib.inrento.retrofit.NetworkAuthTokenApiFactory
import kotlinx.coroutines.CompletableDeferred
import kotlinx.coroutines.Deferred
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.TestInstance
import org.junit.jupiter.api.TestInstance.Lifecycle

@TestInstance(Lifecycle.PER_METHOD)
open class BaseTest {

    companion object {
        private const val userAgent = "okhttp/3.12.1"
        private val customApiCredentials = CustomApiCredentials(
            key = "x-api-key",
            token = "insert_token"
        )
        private val timeout: Long? = null
        private val loggingLevel = HttpLoggingInterceptor.Level.BODY

        private val errorLoggerInterface = object : ErrorLoggerInterface {
            override fun log(request: Request, error: ApiError) {
                //  log
            }
        }
    }

    protected lateinit var apiClient: InRentoApiClient
    protected lateinit var accessAuthTokenApiClient: InRentoAccessTokenApiClient
    protected lateinit var authAuthTokenApiClient: InRentoAuthTokenApiClient

    @BeforeAll
    open fun setUp() {
        accessAuthTokenApiClient = NetworkAccessTokenApiFactory(
            baseUrl = " https://test-api.inrento.com/paysera/v1/",
            locale = "lt",
            userAgent = userAgent,
            credentials = customApiCredentials,
            timeout = timeout,
            httpLoggingInterceptorLevel = loggingLevel,
            errorLogger = errorLoggerInterface,
            certificateInterceptor = null
        ).createClient(null)
        authAuthTokenApiClient = NetworkAuthTokenApiFactory(
            baseUrl = " https://test-api.inrento.com/paysera/v1/",
            locale = "lt",
            userAgent = userAgent,
            timeout = timeout,
            httpLoggingInterceptorLevel = loggingLevel,
            errorLogger = errorLoggerInterface,
            certificateInterceptor = null
        ).createClient(null)
    }

    open fun setUpRefreshingApiCalls(authToken: String?) {
        apiClient = NetworkApiFactory(
            baseUrl = " https://test-api.inrento.com/paysera/v1/",
            locale = "lt",
            userAgent = userAgent,
            credentials = InRentoApiCredentials(token = authToken),
            timeout = timeout,
            httpLoggingInterceptorLevel = loggingLevel,
            errorLogger = errorLoggerInterface,
            certificateInterceptor = null
        ).createClient(object : TokenRefresherInterface {
            override fun refreshToken(): Deferred<Any> {
                return CompletableDeferred(1)
            }
        })
    }

    @AfterAll
    open fun tearDown() {
        apiClient.cancelCalls()
    }
}