package ru.students.vocabulary.model.repository

import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {

    override suspend fun getData(word: String): List<DataModel> {
        return dataSource.getData(word)
    }
}
