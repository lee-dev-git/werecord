package a.alt.z.werecord.di

import a.alt.z.werecord.data.repository.MovieRepositoryImpl
import a.alt.z.werecord.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun bindsMovieRepository(repository: MovieRepositoryImpl): MovieRepository
}