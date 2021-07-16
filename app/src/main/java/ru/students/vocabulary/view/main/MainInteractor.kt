package ru.students.vocabulary.view.main

import ru.students.model.data.AppState
import ru.students.vocabulary.model.data.DataModel
import ru.students.repository.repository.Repository
import ru.students.repository.repository.RepositoryLocal

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : ru.students.core.viewmodel.Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        // Теперь полученное слово мы сохраняем в БД
        if (fromRemoteSource) {
            appState = AppState.Success(repositoryRemote.getData(word))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(repositoryLocal.getData(word))
        }
        return appState
    }
}

