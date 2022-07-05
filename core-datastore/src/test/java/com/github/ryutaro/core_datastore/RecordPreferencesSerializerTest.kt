package com.github.ryutaro.core_datastore

import com.github.ryutaro.daily_ranking.core.datastore.recordPreferences
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Test

class RecordPreferencesSerializerTest {
    private val recordPreferencesSerializer = RecordPreferencesSerializer

    @Test
    fun `Testing the Initial values of the DataStore`() {
        assertEquals(
            recordPreferences {

            },
            recordPreferencesSerializer.defaultValue
        )
    }
}
