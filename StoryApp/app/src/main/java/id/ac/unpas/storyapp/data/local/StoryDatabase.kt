package id.ac.unpas.storyapp.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import id.ac.unpas.storyapp.data.local.dao.UserDao
import id.ac.unpas.storyapp.data.local.entity.UserEntity

@Database(entities = [UserEntity::class], version = 1, exportSchema = false)
abstract class StoryDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}