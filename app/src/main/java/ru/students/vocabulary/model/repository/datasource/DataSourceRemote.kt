package ru.students.vocabulary.model.repository.datasource

import io.reactivex.Observable
import ru.students.vocabulary.model.data.DataModel
import ru.students.vocabulary.model.repository.RetrofitImpl

class DataSourceRemote(private val remoteProvider: RetrofitImpl = RetrofitImpl()) :
    DataSource<List<DataModel>> {

    override fun getData(word: String): Observable<List<DataModel>> = remoteProvider.getData(word)
}
