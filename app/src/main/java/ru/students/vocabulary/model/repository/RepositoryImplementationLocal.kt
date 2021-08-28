package ru.students.vocabulary.model.repository

import ru.students.vocabulary.model.data.AppState
import ru.students.vocabulary.model.datasource.DataSourceLocal
import ru.students.vocabulary.model.data.DataModel

class RepositoryImplementationLocal(private val dataSource: DataSourceLocal<List<DataModel>>) :
    RepositoryLocal<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }

    override suspend fun saveToDB(appState: AppState) {
        dataSource.saveToDB(appState)
    }
}
