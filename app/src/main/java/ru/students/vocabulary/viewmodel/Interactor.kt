package ru.students.vocabulary.viewmodel

interface Interactor<T> {

    suspend fun getData(word: String, fromRemoteSource: Boolean): T
}
