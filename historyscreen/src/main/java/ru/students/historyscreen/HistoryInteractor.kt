package ru.students.historyscreen

import ru.students.vocabulary.model.data.AppState
import ru.students.vocabulary.model.data.DataModel
import ru.students.repository.repository.Repository
import ru.students.repository.repository.RepositoryLocal


class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : ru.students.core.viewmodel.Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState{
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}

