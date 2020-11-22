package a.alt.z.werecord.di

import a.alt.z.werecord.data.api.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object NetworkModule {

    @Provides @TmdbInterceptor
    fun providesTmdbInterceptor(): Interceptor = TmdbAuthInterceptor()

    @Provides @TmdbClient
    fun providesOkHttpClient(@TmdbInterceptor interceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()

    @Provides @Singleton
    fun providesTmdbService(@TmdbClient client: OkHttpClient): TmdbService = Retrofit.Builder()
        .baseUrl(TmdbApi.BASE_URL)
        .client(client)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(TmdbService::class.java)

    @Provides @KopisInterceptor
    fun providesKopisInterceptor(): Interceptor = KopisAuthInterceptor()

    @Provides @Singleton
    fun providesLoggingInterceptor(): Interceptor = HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Provides @KopisClient
    fun providesKopisClient(@KopisInterceptor interceptor: Interceptor, loggingInterceptor: Interceptor): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .addInterceptor(loggingInterceptor)
        .build()

    @Provides @Singleton
    fun providesKopisService(@KopisClient client: OkHttpClient): KopisService = Retrofit.Builder()
        .baseUrl(KopisApi.BASE_URL)
        .client(client)
        .addConverterFactory(SimpleXmlConverterFactory.create())
        .build()
        .create(KopisService::class.java)
}