package ru.students.vocabulary.model.datasource

interface DataSource<T> {

    suspend fun getData(word: String): T
}
