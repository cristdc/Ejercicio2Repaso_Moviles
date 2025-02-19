package dam.moviles.ejercicio2_repaso.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DatosTiempo(
    val pressure:Int,
    val humidity:Int,
    val wind_speed:Double,
    val weather:List<ResumenTiempo>,
    val temp:Double
)
