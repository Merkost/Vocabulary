package ru.students.vocabulary.di

import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.datasource.RetrofitImplementation
import ru.students.vocabulary.model.datasource.RoomDataBaseImplementation
import ru.students.vocabulary.model.repository.Repository
import ru.students.vocabulary.model.repository.RepositoryImplementation
import ru.students.vocabulary.view.main.MainInteractor
import ru.students.vocabulary.view.main.MainViewModel

val application = module {
    single<Repository<List<DataModel>>>(named(NAME_REMOTE)) { RepositoryImplementation(RetrofitImplementation()) }
    single<Repository<List<DataModel>>>(named(NAME_LOCAL)) { RepositoryImplementation(RoomDataBaseImplementation()) }
}

val mainScreen = module {
    factory { MainInteractor(get(named(NAME_REMOTE)), get(named(NAME_LOCAL))) }
    factory { MainViewModel(get()) }
}
