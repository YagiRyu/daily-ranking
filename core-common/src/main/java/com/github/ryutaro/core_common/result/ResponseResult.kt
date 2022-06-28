package com.github.ryutaro.core_common.result

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart

sealed interface ResponseResult<out T> {
    object Proceeding : ResponseResult<Nothing>
    data class Success<T>(val data: T) : ResponseResult<T>
    data class Error(val exception: Throwable?) : ResponseResult<Nothing>
}

fun <T> Flow<T>.asResult(): Flow<ResponseResult<T>> {
    return this
        .map<T, ResponseResult<T>> {
            ResponseResult.Success(it)
        }
        .onStart { emit(ResponseResult.Proceeding) }
        .catch { emit(ResponseResult.Error(it)) }
}
