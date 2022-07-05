package com.github.ryutaro.core_datastore

import android.content.Context
import androidx.datastore.core.CorruptionException
import androidx.datastore.core.DataStore
import androidx.datastore.core.Serializer
import androidx.datastore.dataStore
import com.github.ryutaro.daily_ranking.core.datastore.RecordPreferences
import com.google.protobuf.InvalidProtocolBufferException
import java.io.InputStream
import java.io.OutputStream

private const val DATA_STORE_FILE_NAME = "settings.proto"

object RecordPreferencesSerializer : Serializer<RecordPreferences> {

    override val defaultValue: RecordPreferences
        get() = RecordPreferences.getDefaultInstance()

    override suspend fun readFrom(input: InputStream): RecordPreferences {
        try {
            @Suppress("BlockingMethodInNonBlockingContext")
            return RecordPreferences.parseFrom(input)
        } catch (exception: InvalidProtocolBufferException) {
            throw CorruptionException("Cannot read proto.", exception)
        }
    }

    override suspend fun writeTo(t: RecordPreferences, output: OutputStream) {
        @Suppress("BlockingMethodInNonBlockingContext")
        t.writeTo(output)
    }

    val Context.recordDataStore: DataStore<RecordPreferences> by dataStore(
        fileName = DATA_STORE_FILE_NAME,
        serializer = RecordPreferencesSerializer
    )
}
