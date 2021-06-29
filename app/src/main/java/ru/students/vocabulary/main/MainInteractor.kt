package ru.students.vocabulary.main

import io.reactivex.Observable
import ru.students.vocabulary.model.data.AppState
import ru.students.vocabulary.Interactor
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.Repository

class MainInteractor(
    // Снабжаем интерактор репозиторием для получения данных
    private val remoteRepository: Repository<List<DataModel>>,
    private val localRepository: Repository<List<DataModel>>
) : Interactor<AppState> {
    // Интерактор лишь запрашивает у репозитория данные
    override fun getData(word: String, fromRemoteSource: Boolean): Observable<AppState> {
        return if (fromRemoteSource) {
            remoteRepository.getData(word).map { AppState.Success(it) }
        } else {
            localRepository.getData(word).map { AppState.Success(it) }
        }
    }
}