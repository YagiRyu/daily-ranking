package com.github.ryutaro.core_datastore_test

import androidx.datastore.core.DataStore
import androidx.datastore.core.DataStoreFactory
import com.github.ryutaro.core_datastore.RecordPreferencesSerializer
import com.github.ryutaro.core_datastore.di.DataStoreModule
import com.github.ryutaro.daily_ranking.core.datastore.RecordPreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import org.junit.rules.TemporaryFolder
import javax.inject.Singleton

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DataStoreModule::class]
)
object TestDataStoreModule {

    @Provides
    @Singleton
    fun provideRecordPreferencesDataStore(
        recordPreferencesSerializer: RecordPreferencesSerializer,
        tmpFolder: TemporaryFolder
    ): DataStore<RecordPreferences> = tmpFolder.testRecordPreferencesDataStore(recordPreferencesSerializer)
}

fun TemporaryFolder.testRecordPreferencesDataStore(
    recordPreferencesSerializer: RecordPreferencesSerializer
) = DataStoreFactory.create(
    serializer = recordPreferencesSerializer
) {
    newFile("record_preferences_test.proto")
}
