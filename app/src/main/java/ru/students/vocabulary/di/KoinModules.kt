package ru.students.vocabulary.di

import androidx.room.Room
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
import ru.students.historyscreen.HistoryInteractor
import ru.students.historyscreen.HistoryViewModel

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
    factory { ru.students.historyscreen.HistoryViewModel(get()) }
    factory { ru.students.historyscreen.HistoryInteractor(get(), get()) }
}
