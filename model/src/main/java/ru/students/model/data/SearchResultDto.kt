package ru.students.model.data

import com.google.gson.annotations.SerializedName
import ru.students.model.data.MeaningsDto

data class SearchResultDto(
    @field:SerializedName("text") val text: String?,
    @field:SerializedName("meanings") val meanings: List<MeaningsDto>?
)
