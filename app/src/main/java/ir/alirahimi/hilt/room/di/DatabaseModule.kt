package ir.alirahimi.hilt.room.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import ir.alirahimi.hilt.room.db.User
import ir.alirahimi.hilt.room.db.UserDatabase
import ir.alirahimi.hilt.util.Constants
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        UserDatabase::class.java,
        Constants.USER_DATABASE
    ).allowMainThreadQueries()
        .fallbackToDestructiveMigration()
        .build()

    @Provides
    @Singleton
    fun provideDao(database: UserDatabase) = database.userDao()

    @Provides
    fun provideEntity() = User()

}