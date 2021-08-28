package ru.students.vocabulary.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(indices = [Index(value = arrayOf("word"), unique = true)])
class HistoryEntity(
    // Далее всё стандартно для любой БД. Мы храним слово и его перевод
    // (перевод не сохраняется в текущем приложении, но вы можете
    // имплементировать дополнительный функционал самостоятельно)
    @PrimaryKey
    @ColumnInfo(name = "word")
    var word: String,
    @ColumnInfo(name = "description")
    var description: String?
)