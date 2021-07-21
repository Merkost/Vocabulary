package ru.students.vocabulary.view.main

import ru.students.core.viewmodel.Interactor
import ru.students.model.data.AppState
import ru.students.model.data.SearchResultDto
import ru.students.repository.repository.Repository
import ru.students.repository.repository.RepositoryLocal
import ru.students.repository.utils.mapSearchResultToResult

class MainInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        val appState: AppState
        if (fromRemoteSource) {
            appState = AppState.Success(mapSearchResultToResult(repositoryRemote.getData(word)))
            repositoryLocal.saveToDB(appState)
        } else {
            appState = AppState.Success(mapSearchResultToResult(repositoryLocal.getData(word)))
        }
        return appState
    }
}

