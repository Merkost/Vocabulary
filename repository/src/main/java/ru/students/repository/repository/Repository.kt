package ru.students.repository.repository

interface Repository<T> {

    suspend fun getData(word: String): T
}
