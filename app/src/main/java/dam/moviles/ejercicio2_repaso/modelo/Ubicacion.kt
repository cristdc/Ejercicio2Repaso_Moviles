package dam.moviles.ejercicio2_repaso.modelo

import com.squareup.moshi.JsonClass
import java.io.Serializable

@JsonClass(generateAdapter = true)
data class Ubicacion(
    val name:String,
    val lat:Double,
    val lon:Double,
    val country:String
):Serializable
