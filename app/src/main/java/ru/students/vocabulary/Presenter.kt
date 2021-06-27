package ru.students.vocabulary

import ru.students.vocabulary.main.base.View
import ru.students.vocabulary.model.data.AppState

interface Presenter<T : AppState, V : View> {

    fun attachView(view: V)

    fun detachView(view: V)
    // Получение данных с флагом isOnline(из Интернета или нет)
    fun getData(word: String, isOnline: Boolean)
}