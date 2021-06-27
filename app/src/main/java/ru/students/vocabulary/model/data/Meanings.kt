package ru.students.vocabulary.model.data

import com.google.gson.annotations.SerializedName
import ru.students.vocabulary.model.data.Translation

class Meanings(
    @field:SerializedName("translation") val translation: Translation?,
    @field:SerializedName("imageUrl") val imageUrl: String?
)
