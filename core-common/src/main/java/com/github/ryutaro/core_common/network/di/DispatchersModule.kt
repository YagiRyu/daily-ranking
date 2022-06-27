package com.github.ryutaro.core_common.network.di

import com.github.ryutaro.core_common.network.DefaultDispatcher
import com.github.ryutaro.core_common.network.IoDispatcher
import com.github.ryutaro.core_common.network.MainDispatcher
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers

@Module
object DispatchersModule {
    @Provides
    @DefaultDispatcher
    fun provideDefaultDispatcher(): CoroutineDispatcher = Dispatchers.Default

    @Provides
    @IoDispatcher
    fun provideIoDispatcher(): CoroutineDispatcher = Dispatchers.IO

    @Provides
    @MainDispatcher
    fun provideMainDispatcher(): CoroutineDispatcher = Dispatchers.Main
}
