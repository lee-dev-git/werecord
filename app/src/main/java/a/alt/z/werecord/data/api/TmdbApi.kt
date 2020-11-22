package a.alt.z.werecord.data.api

import a.alt.z.werecord.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Qualifier

object TmdbApi {
    const val BASE_URL = "https://api.themoviedb.org/3/"
}

class TmdbAuthInterceptor: Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val httpUrl = chain.request()
            .url
            .newBuilder()
            .addQueryParameter("api_key", BuildConfig.TMDB_API_KEY)
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
annotation class TmdbInterceptor

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class TmdbClient