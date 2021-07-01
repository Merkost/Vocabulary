package ru.students.vocabulary.main.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.Provides
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import ru.students.vocabulary.main.application.TranslatorApp
import javax.inject.Singleton

@Component(
    modules = [
        InteractorModule::class,
        RepositoryModule::class,
        ViewModelModule::class,
        ActivityModule::class,
        AndroidInjectionModule::class]
)

@Singleton
interface AppComponent : AndroidInjector<TranslatorApp> {

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder
        fun build(): AppComponent
    }

    override fun inject(englishVocabularyApp: TranslatorApp)
}
