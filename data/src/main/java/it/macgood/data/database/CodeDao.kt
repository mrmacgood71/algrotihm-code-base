package it.macgood.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import it.macgood.data.entity.Algorithm
import kotlinx.coroutines.flow.Flow

@Dao
interface CodeDao {

    @Query("SELECT * FROM algorithm")
    fun getAllAlgorithms() : Flow<List<Algorithm>>

    @Query("SELECT * FROM algorithm WHERE id = :id")
    suspend fun getAlgorithmImpl(id: Long): Algorithm

    @Insert
    suspend fun prepopulateCodes(codeList: List<Algorithm>)

}
