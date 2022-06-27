package com.github.ryutaro.core_test.di

import com.github.ryutaro.core_common.network.DefaultDispatcher
import dagger.Module
import dagger.hilt.components.SingletonComponent
import dagger.hilt.testing.TestInstallIn
import com.github.ryutaro.core_common.network.di.DispatchersModule
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.test.TestDispatcher

@Module
@TestInstallIn(
    components = [SingletonComponent::class],
    replaces = [DispatchersModule::class]
)
object TestCoroutineDispatchersModule {
    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(testDispatcher: TestDispatcher): CoroutineDispatcher = testDispatcher
}
