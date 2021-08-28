package ru.students.vocabulary.model.repository

import ru.students.vocabulary.model.data.AppState

interface RepositoryLocal<T> : Repository<T> {

    suspend fun saveToDB(appState: AppState)
}
