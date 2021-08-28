package ru.students.historyscreen

import androidx.room.Room
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module
import ru.students.vocabulary.model.data.DataModel
import ru.students.repository.datasource.RetrofitImplementation
import ru.students.repository.datasource.RoomDataBaseImplementation
import ru.students.repository.repository.Repository
import ru.students.repository.repository.RepositoryImplementation
import ru.students.repository.repository.RepositoryImplementationLocal
import ru.students.repository.repository.RepositoryLocal
import ru.students.repository.room.HistoryDataBase
import ru.students.vocabulary.view.main.MainInteractor
import ru.students.vocabulary.view.main.MainViewModel

fun injectDependencies() = loadFeature

private val loadFeature by lazy {
    loadKoinModules(listOf(historyScreen))
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}