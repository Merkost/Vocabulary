package ru.students.vocabulary.di

import androidx.room.Room
import org.koin.dsl.module
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.datasource.RetrofitImplementation
import ru.students.vocabulary.model.datasource.RoomDataBaseImplementation
import ru.students.vocabulary.model.repository.Repository
import ru.students.vocabulary.model.repository.RepositoryImplementation
import ru.students.vocabulary.model.repository.RepositoryImplementationLocal
import ru.students.vocabulary.model.repository.RepositoryLocal
import ru.students.vocabulary.room.HistoryDataBase
import ru.students.vocabulary.view.main.MainInteractor
import ru.students.vocabulary.view.main.MainViewModel
import ru.students.vocabulary.view.main.history.HistoryInteractor
import ru.students.vocabulary.view.main.history.HistoryViewModel

val application = module {
    // single указывает, что БД должна быть в единственном экземпляре
    single { Room.databaseBuilder(get(), HistoryDataBase::class.java, "HistoryDB").build() }
    // Получаем DAO
    single { get<HistoryDataBase>().historyDao() }
    single<Repository<List<DataModel>>> { RepositoryImplementation(RetrofitImplementation()) }
    single<RepositoryLocal<List<DataModel>>> { RepositoryImplementationLocal(RoomDataBaseImplementation(get())) }
}

val mainScreen = module {
    factory { MainInteractor(get(), get()) }
    factory { MainViewModel(get()) }
}

val historyScreen = module {
    factory { HistoryViewModel(get()) }
    factory { HistoryInteractor(get(), get()) }
}
