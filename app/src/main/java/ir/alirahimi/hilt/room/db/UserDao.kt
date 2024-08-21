package ir.alirahimi.hilt.room.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import ir.alirahimi.hilt.util.Constants

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertUser(user: User)

    @Query("SELECT * FROM ${Constants.USER_DATABASE}")
    fun getAllUsers(): MutableList<User>

}