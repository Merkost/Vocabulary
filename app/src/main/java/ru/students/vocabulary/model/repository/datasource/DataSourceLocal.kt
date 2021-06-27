package ru.students.vocabulary.model.repository.datasource

import io.reactivex.Observable
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.RoomImpl

class DataSourceLocal(private val remoteProvider: RoomImpl = RoomImpl()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
