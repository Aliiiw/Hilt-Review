package ir.alirahimi.hilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import ir.alirahimi.hilt.di.qualifier.UserFullName
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MainModule {

    @Provides
    @Singleton
    fun provideUsername(): String = "Ali Rahimi"

    @Provides
    @UserFullName
    fun provideUserFullName(): String = "Ali Rahimi"


}