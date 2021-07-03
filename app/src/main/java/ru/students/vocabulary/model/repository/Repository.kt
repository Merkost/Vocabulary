package ru.students.vocabulary.model.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
