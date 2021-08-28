package ru.students.repository.datasource

import ru.students.model.data.AppState
import ru.students.model.data.SearchResultDto
import ru.students.model.data.userdata.DataModel
import ru.students.repository.convertDataModelSuccessToEntity
import ru.students.repository.mapHistoryEntityToSearchResult
import ru.students.repository.room.HistoryDao

class RoomDataBaseImplementation(private val historyDao: HistoryDao) :
    DataSourceLocal<List<SearchResultDto>> {

    override suspend fun getData(word: String): List<SearchResultDto> {
        return mapHistoryEntityToSearchResult(historyDao.all())
    }

    override suspend fun saveToDB(appState: AppState) {
        convertDataModelSuccessToEntity(appState)?.let {
            historyDao.insert(it)
        }
    }
}