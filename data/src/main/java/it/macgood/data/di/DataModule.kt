package it.macgood.data.di

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import it.macgood.data.database.CodeDao
import it.macgood.data.database.CodeDatabase.Companion.DATABASE_NAME
import javax.inject.Provider
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DataModule {
    @Provides
    @Singleton
    fun provideCodeDatabase(
        app: Application,
        provider: Provider<CodeDao>
    ): it.macgood.data.database.CodeDatabase {
        return Room.databaseBuilder(
            app.applicationContext,
            it.macgood.data.database.CodeDatabase::class.java,
            DATABASE_NAME
        ).addCallback(
            it.macgood.data.database.CodeInsertCallback(app.applicationContext, provider)
        ).build()
    }

    @Provides
    @Singleton
    fun provideCodeDao(db: it.macgood.data.database.CodeDatabase): CodeDao = db.codeDao
}