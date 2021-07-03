package ru.students.vocabulary.view.main

import ru.students.vocabulary.viewmodel.Interactor
import ru.students.vocabulary.model.data.AppState
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.Repository

class MainInteractor(
    private val repositoryRemote: Repository<List<DataModel>>,
    private val repositoryLocal: Repository<List<DataModel>>
) : Interactor<AppState> {

    override suspend fun getData(word: String, fromRemoteSource: Boolean): AppState {
        return AppState.Success(
            if (fromRemoteSource) {
                repositoryRemote
            } else {
                repositoryLocal
            }.getData(word)
        )
    }
}
