package ru.students.vocabulary.main.base

import ru.students.vocabulary.model.data.AppState

interface View {
    // View имеет только один метод, в который приходит некое состояние приложения
    fun renderData(appState: AppState)

}