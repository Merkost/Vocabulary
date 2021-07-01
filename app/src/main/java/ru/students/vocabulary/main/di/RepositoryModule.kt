package ru.students.vocabulary.main.di

import dagger.Module
import dagger.Provides
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.Repository
import ru.students.vocabulary.model.repository.RepositoryImplementation
import ru.students.vocabulary.model.repository.RetrofitImpl
import ru.students.vocabulary.model.repository.RoomImpl
import ru.students.vocabulary.model.repository.datasource.DataSource
import javax.inject.Named
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideRepositoryRemote(@Named(NAME_REMOTE) dataSourceRemote: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImplementation(dataSourceRemote)

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideRepositoryLocal(@Named(NAME_LOCAL) dataSourceLocal: DataSource<List<DataModel>>): Repository<List<DataModel>> =
        RepositoryImplementation(dataSourceLocal)

    @Provides
    @Singleton
    @Named(NAME_REMOTE)
    internal fun provideDataSourceRemote(): DataSource<List<DataModel>> =
        RetrofitImpl()

    @Provides
    @Singleton
    @Named(NAME_LOCAL)
    internal fun provideDataSourceLocal(): DataSource<List<DataModel>> = RoomImpl()
}
