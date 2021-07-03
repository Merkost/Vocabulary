package ru.students.vocabulary.application

import android.app.Application
import org.koin.core.context.startKoin
import ru.students.vocabulary.di.application
import ru.students.vocabulary.di.mainScreen

class TranslatorApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(listOf(application, mainScreen))
        }
    }
}
