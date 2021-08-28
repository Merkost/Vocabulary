package ru.students.vocabulary.model.datasource

import ru.students.vocabulary.model.data.AppState

interface DataSourceLocal<T> : DataSource<T> {

    suspend fun saveToDB(appState: AppState)
}
