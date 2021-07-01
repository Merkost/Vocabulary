package ru.students.vocabulary.main.di

import dagger.Module
import dagger.Provides
import ru.students.vocabulary.main.MainInteractor
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.Repository
import javax.inject.Named

@Module
class InteractorModule {

    @Provides
    internal fun provideInteractor(
        @Named(NAME_REMOTE) repositoryRemote: Repository<List<DataModel>>,
        @Named(NAME_LOCAL) repositoryLocal: Repository<List<DataModel>>
    ) = MainInteractor(repositoryRemote, repositoryLocal)
}
