package id.ac.unpas.storyapp.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import id.ac.unpas.storyapp.data.local.StoryDatabase
import id.ac.unpas.storyapp.data.local.dao.UserDao
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): StoryDatabase {
        return Room.databaseBuilder(
            context,
            StoryDatabase::class.java,
            "story_database"
        ).fallbackToDestructiveMigration().build()
    }

    @Provides
    fun provideUserDao(database: StoryDatabase): UserDao {
        return database.userDao()
    }
}