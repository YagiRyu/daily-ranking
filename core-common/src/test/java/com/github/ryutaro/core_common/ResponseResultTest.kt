package com.github.ryutaro.core_common

import app.cash.turbine.test
import com.github.ryutaro.core_common.result.ResponseResult
import com.github.ryutaro.core_common.result.asResult
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class ResponseResultTest {
    @Test
    fun responseResultTest() = runTest {
        flow {
            emit(1)
            throw Exception("Test Done")
        }
            .asResult()
            .test {
                assertEquals(ResponseResult.Proceeding, awaitItem())
                assertEquals(ResponseResult.Success(1), awaitItem())

                when (val errorResult = awaitItem()) {
                    is ResponseResult.Error -> assertEquals(
                        "Test Done",
                        errorResult.exception?.message
                    )
                    ResponseResult.Proceeding,
                    is ResponseResult.Success -> throw IllegalStateException(
                        "The flow should have emitted an Error Result"
                    )
                }
                awaitComplete()
            }
    }
}
