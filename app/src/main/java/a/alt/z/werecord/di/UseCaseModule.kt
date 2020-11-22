package a.alt.z.werecord.di

import a.alt.z.werecord.domain.repository.MovieRepository
import a.alt.z.werecord.domain.usecase.movie.GetTrendingMoviesUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object UseCaseModule {

    @Singleton @Provides
    fun providesGetPopularMoviesUseCase(
            movieRepository: MovieRepository,
            @IODispatcher coroutineDispatcher: CoroutineDispatcher
    ): GetTrendingMoviesUseCase = GetTrendingMoviesUseCase(movieRepository, coroutineDispatcher)
}