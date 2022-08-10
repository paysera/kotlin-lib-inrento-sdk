package com.paysera.lib.inrento.clients

import com.paysera.lib.common.entities.XAuthTokenApiCredentials
import com.paysera.lib.common.exceptions.ApiError
import com.paysera.lib.common.interfaces.ErrorLoggerInterface
import com.paysera.lib.common.interfaces.TokenRefresherInterface
import com.paysera.lib.inrento.retrofit.NetworkApiFactory
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
        private val userAgent = "okhttp/3.12.1"
        private val xApiCredentials = XAuthTokenApiCredentials(
            xApiKey = "insert_x_api_key",
            token = "insert_token"
        )
        private val timeout: Long? = null
        private val loggingLevel = HttpLoggingInterceptor.Level.BODY

        private val errorLoggerInterface = object : ErrorLoggerInterface {
            override fun log(request: Request, error: ApiError) {
                //  log
            }
        }
        private val tokenRefresher = object : TokenRefresherInterface {
            override fun refreshToken(): Deferred<Any> {
                return CompletableDeferred(1)
            }
        }
    }

    protected lateinit var apiClient: InRentoApiClient

    @BeforeAll
    open fun setUp() {
        apiClient = NetworkApiFactory(
            baseUrl = " https://test-api.inrento.com/paysera/v1/",
            locale = "lt",
            userAgent = userAgent,
            credentials = xApiCredentials,
            timeout = timeout,
            httpLoggingInterceptorLevel = loggingLevel,
            errorLogger = errorLoggerInterface,
            certificateInterceptor = null
        ).createClient(tokenRefresher)
    }

    @AfterAll
    open fun tearDown() {
        apiClient.cancelCalls()
    }
}