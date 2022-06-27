package com.github.ryutaro.core_common.result

sealed interface ResponseResult<out T> {
    object Proceeding : ResponseResult<Nothing>
    object Success : ResponseResult<Nothing>
    object Error : ResponseResult<Nothing>
}
