package it.macgood.data.entity
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.serialization.Serializable

@Entity(tableName = "algorithm")
@Serializable
data class Algorithm(
    @PrimaryKey
    val id: Long,
    val name: String,
    val description: String,
    val cppImpl: String,
    val pythonImpl: String,
    val javaImpl: String
) {
}