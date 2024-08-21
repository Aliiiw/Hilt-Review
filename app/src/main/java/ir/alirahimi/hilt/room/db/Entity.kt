package ir.alirahimi.hilt.room.db

import androidx.room.Entity
import androidx.room.PrimaryKey
import ir.alirahimi.hilt.util.Constants

@Entity(tableName = Constants.USER_DATABASE)
data class User(
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0,
    var name: String = ""
)