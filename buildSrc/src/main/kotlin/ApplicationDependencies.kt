object ApplicationDependencies {

    object GradlePlugins {
        const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${ApplicationDependencyVersions.kotlin}"
    }

    private const val kotlinStandardLib = "org.jetbrains.kotlin:kotlin-stdlib:${ApplicationDependencyVersions.kotlin}"
    private const val kotlinxCoroutinesCore = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${ApplicationDependencyVersions.kotlinCoroutinesCore}"
    private const val converterGson = "com.squareup.retrofit2:converter-gson:${ApplicationDependencyVersions.retrofit}"
    private const val retrofit = "com.squareup.retrofit2:retrofit:${ApplicationDependencyVersions.retrofit}"
    private const val loggingInterceptor = "com.squareup.okhttp3:logging-interceptor:${ApplicationDependencyVersions.loggingInterceptor}"
    private const val gson = "com.google.code.gson:gson:${ApplicationDependencyVersions.gson}"
    private const val payseraCommonSdk = "com.paysera.lib:kotlin-lib-common-sdk:${ApplicationDependencyVersions.payseraCommonSdk}"
    private const val jodaMoney = "org.joda:joda-money:${ApplicationDependencyVersions.jodaMoney}"

    object TestingPlugins {
        const val assertjCore = "org.assertj:assertj-core:${ApplicationDependencyVersions.assertjCore}"
        const val jupiterApi = "org.junit.jupiter:junit-jupiter-api:${ApplicationDependencyVersions.jupiter}"
        const val jupiterEngine = "org.junit.jupiter:junit-jupiter-engine:${ApplicationDependencyVersions.jupiter}"
    }

    val dependencies = arrayListOf(
        kotlinStandardLib,
        kotlinxCoroutinesCore,
        converterGson,
        retrofit,
        loggingInterceptor,
        gson,
        payseraCommonSdk,
        jodaMoney
    )
}