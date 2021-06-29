package ru.students.vocabulary

import io.reactivex.Observable

interface Interactor<T> {
    // Use Сase: получение данных для вывода на экран
    fun getData(word: String, fromRemoteSource: Boolean): Observable<T>
}
