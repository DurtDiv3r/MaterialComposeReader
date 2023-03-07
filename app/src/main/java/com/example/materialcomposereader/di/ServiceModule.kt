package com.example.materialcomposereader.di

import com.example.materialcomposereader.model.service.LoginService
import com.example.materialcomposereader.model.service.impl.LoginServiceImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class ServiceModule {
    @Binds
    abstract fun provideLoginService(impl: LoginServiceImpl): LoginService
}
