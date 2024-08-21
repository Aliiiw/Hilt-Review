package ir.alirahimi.hilt.di

import android.content.Context
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.alirahimi.hilt.R
import ir.alirahimi.hilt.util.Constants
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    @Named(Constants.NAMED_RES_STRING)
    fun getStringFromResources(@ApplicationContext context: Context): String {
        return context.getString(R.string.test_info)
    }

}