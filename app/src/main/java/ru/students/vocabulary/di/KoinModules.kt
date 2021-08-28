package ru.students.vocabulary.di

import androidx.room.Room
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.context.loadKoinModules
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.students.model.data.SearchResultDto

import ru.students.repository.datasource.RetrofitImplementation
import ru.students.repository.datasource.RoomDataBaseImplementation
import ru.students.repository.repository.Repository
import ru.students.repository.repository.RepositoryImplementation
import ru.students.repository.repository.RepositoryImplementationLocal
import ru.students.repository.repository.RepositoryLocal
import ru.students.repository.room.HistoryDataBase
import ru.students.vocabulary.view.main.MainActivity
import ru.students.vocabulary.view.main.MainInteractor
import ru.students.vocabulary.view.main.MainViewModel

fun injectDependencies() = loadModules

private val loadModules by lazy {
    // Функция библиотеки Koin
    loadKoinModules(listOf(application, mainScreen))
}

val application = module {
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<SearchResultDto>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<SearchResultDto>>> {
        RepositoryImplementationLocal(RoomDataBaseImplementation(get()))
    }
}


val mainScreen = module {
    scope(named<MainActivity>()) {
        scoped { MainInteractor(get(), get()) }
        viewModel { MainViewModel(get()) }
    }
}