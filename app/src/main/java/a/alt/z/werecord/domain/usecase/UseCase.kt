package a.alt.z.werecord.domain.usecase

import kotlinx.coroutines.*
import timber.log.Timber

abstract class UseCase<in P, R>(private val coroutineDispatcher: CoroutineDispatcher) {

    suspend operator fun invoke(parameters: P): Result<R> {
        return try {
            withContext(coroutineDispatcher) {
                execute(parameters).let { data ->
                    Timber.d("${this::class.java.simpleName} executed")
                    Result.Success(data)
                }
            }
        }
        catch (exception: Exception) {
            Timber.d(exception, "${this::class.java.simpleName} failed")
            Result.Error(exception)
        }
    }

    protected abstract suspend fun execute(parameters: P): R
}