package a.alt.z.werecord.di

import a.alt.z.werecord.data.db.AppDatabase
import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object DatabaseModule {

    @Provides @Singleton
    fun providesAppDatabase(@ApplicationContext context: Context) = AppDatabase.buildDatabase(context)

    @Provides @Singleton
    fun providesMovieDao(database: AppDatabase) = database.movieDao()

    @Provides @Singleton
    fun providesPerformanceDao(database: AppDatabase) = database.performanceDao()
}