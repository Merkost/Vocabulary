package ru.students.vocabulary.main.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ru.students.vocabulary.main.MainActivity


@Module
abstract class ActivityModule {

    @ContributesAndroidInjector
    abstract fun contributeMainActivity(): MainActivity
}
