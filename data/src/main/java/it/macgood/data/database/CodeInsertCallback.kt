package it.macgood.data.database

import android.content.Context
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import it.macgood.data.R
import it.macgood.data.entity.Algorithm
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.decodeFromStream
import javax.inject.Provider

class CodeInsertCallback(
    private val context: Context,
    private val provider: Provider<CodeDao>
) : RoomDatabase.Callback() {

    private val applicationScope = CoroutineScope(SupervisorJob())

    override fun onCreate(db: SupportSQLiteDatabase) {
        super.onCreate(db)
        applicationScope.launch(Dispatchers.IO) {
            populateCodes()
        }
    }

    @OptIn(ExperimentalSerializationApi::class)
    private suspend fun populateCodes() {
        val inputStream = context.resources.openRawResource(R.raw.codes)
        val codeList: List<Algorithm> = Json.decodeFromStream(inputStream)
        provider.get().prepopulateCodes(codeList)
    }
}