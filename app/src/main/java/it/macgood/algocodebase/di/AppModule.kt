package it.macgood.algocodebase.di


import it.macgood.data.database.CodeDao
import it.macgood.data.repository.CodeRepositoryImpl
import it.macgood.domain.repository.CodeRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideCodeRepository(dao: CodeDao): it.macgood.domain.repository.CodeRepository {
        return CodeRepositoryImpl(dao)
    }

}