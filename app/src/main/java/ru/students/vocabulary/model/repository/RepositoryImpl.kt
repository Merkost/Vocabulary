package ru.students.vocabulary.model.repository

import io.reactivex.Observable
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.datasource.DataSource
import ru.students.vocabulary.model.repository.Repository

class RepositoryImplementation(private val dataSource: DataSource<List<DataModel>>) :
    Repository<List<DataModel>> {
    // Репозиторий возвращает данные, используя dataSource
    override fun getData(word: String): Observable<List<DataModel>> {
        return dataSource.getData(word)
    }
}