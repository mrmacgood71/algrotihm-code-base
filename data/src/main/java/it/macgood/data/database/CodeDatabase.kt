package it.macgood.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import it.macgood.data.entity.Algorithm

@Database(
    entities = [Algorithm::class],
    version = 1
)
abstract class CodeDatabase : RoomDatabase() {
    abstract val codeDao: CodeDao

    companion object {
        const val DATABASE_NAME = "Code_db"
    }
}