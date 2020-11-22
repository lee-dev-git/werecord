package a.alt.z.werecord.di

import a.alt.z.werecord.data.source.DBMovieDataSource
import a.alt.z.werecord.data.source.MovieLocalDataSource
import a.alt.z.werecord.data.source.MovieRemoteDataSource
import a.alt.z.werecord.data.source.TmdbMovieDataSource
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataSourceModule {

    @Binds
    abstract fun bindMovieLocalDataSource(dbMovieDataSource: DBMovieDataSource): MovieLocalDataSource

    @Binds
    abstract fun bindMovieRemoteDataSource(tmdbMovieDataSource: TmdbMovieDataSource): MovieRemoteDataSource
}