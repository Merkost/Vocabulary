package ru.students.vocabulary.view.main.history

import ru.students.vocabulary.model.data.AppState
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.Repository
import ru.students.vocabulary.model.repository.RepositoryLocal
import ru.students.vocabulary.viewmodel.Interactor


class HistoryInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: RepositoryLocal<List<DataModel>>
) : Interactor<AppState> {

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

