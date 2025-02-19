package dam.moviles.ejercicio2_repaso.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Tiempo(
    val current:DatosTiempo
)
