package ir.alirahimi.hilt.room.db

import androidx.room.Database
import androidx.room.Entity
import androidx.room.RoomDatabase

@Database(entities = [User::class], version = 1, exportSchema = false)
abstract class UserDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}