package a.alt.z.werecord.data.api

import a.alt.z.werecord.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Qualifier

object KopisApi {
    const val BASE_URL = "http://kopis.or.kr/openApi/restful/"
}

class KopisAuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val httpUrl = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("service", BuildConfig.KOPIS_API_KEY)
            .build()

        val request = chain.request()
            .newBuilder()
            .url(url = httpUrl)
            .build()

        return chain.proceed(request)
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class KopisInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class KopisClient