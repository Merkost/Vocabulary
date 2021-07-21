package ru.students.repository.repository

import ru.students.model.data.SearchResultDto
import ru.students.model.data.userdata.DataModel
import ru.students.repository.datasource.DataSource

class RepositoryImplementation(private val dataSource: DataSource<List<SearchResultDto>>) :
    Repository<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return dataSource.getData(word)
    }
}
