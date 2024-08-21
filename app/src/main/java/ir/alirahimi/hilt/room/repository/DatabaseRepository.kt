package ir.alirahimi.hilt.room.repository

import ir.alirahimi.hilt.room.db.User
import ir.alirahimi.hilt.room.db.UserDao
import javax.inject.Inject

class DatabaseRepository @Inject constructor(private val dao: UserDao) {

    fun saveUser(user: User) = dao.insertUser(user)

    fun getAllUsers() = dao.getAllUsers()

}