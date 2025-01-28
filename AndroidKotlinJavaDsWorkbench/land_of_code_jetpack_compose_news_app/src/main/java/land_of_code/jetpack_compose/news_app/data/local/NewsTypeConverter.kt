package land_of_code.jetpack_compose.news_app.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import land_of_code.jetpack_compose.news_app.domain.model.Source

@ProvidedTypeConverter
class NewsTypeConverter {

    @TypeConverter
    fun sourceToString(source: Source): String {
        return "${source.id}, ${source.name}"
    }

    @TypeConverter
    fun stringToSource(source: String): Source {
        return source.split(",").let { sourceArray ->
            Source(sourceArray[0], sourceArray[1])
        }
    }

}