package ru.students.vocabulary.model.repository

import io.reactivex.Observable
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.datasource.DataSource

class RoomImpl : DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> {
        TODO("not implemented")
    }
}