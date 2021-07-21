package ru.students.historyscreen

import ru.students.core.viewmodel.Interactor
import ru.students.model.data.AppState
import ru.students.model.data.SearchResultDto
import ru.students.repository.repository.Repository
import ru.students.repository.repository.RepositoryLocal
import ru.students.repository.utils.mapSearchResultToResult


class HistoryInteractor(
    private val repositoryRemote: Repository<List<SearchResultDto>>,
    private val repositoryLocal: RepositoryLocal<List<SearchResultDto>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            mapSearchResultToResult(
                if (fromRemoteSource) {
                    repositoryRemote
                } else {
                    repositoryLocal
                }.getData(word)
            )
        )
    }
}

