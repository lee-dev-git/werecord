package a.alt.z.werecord.domain.usecase

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed class Result<out R> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
    object Loading : Result<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

val Result<*>.succeeded get() = this is Result.Success && data != null

fun <T> Result<T>.successOr(fallback: T): T = (this as? Result.Success<T>)?.data ?: fallback

val <T> Result<T>.data: T? get() = (this as? Result.Success)?.data

fun <T> Flow<T>.toResult(): Flow<Result<T>>
        = map { Result.Success(it) }
        .onStart { Result.Loading }
        .catch { e -> Result.Error(Exception(e)) }