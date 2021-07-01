package ru.students.vocabulary.main.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable
import ru.students.vocabulary.model.data.AppState
import ru.students.vocabulary.util.scheduler.SchedulerProvider

abstract class BaseViewModel<T : AppState>(

    protected val liveDataForViewToObserve: MutableLiveData<T> = MutableLiveData(),
    protected val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    protected val schedulerProvider: SchedulerProvider = SchedulerProvider()
) : ViewModel() {

    // возвращает LiveData, через которую и передаются данные
    open fun getData(word: String, isOnline: Boolean) = liveDataForViewToObserve

    override fun onCleared() {
        compositeDisposable.clear()
    }
}