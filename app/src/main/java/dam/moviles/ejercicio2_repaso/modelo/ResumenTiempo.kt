package dam.moviles.ejercicio2_repaso.modelo

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResumenTiempo(
    val id:Int,
    val main:String,
    val description:String,
    val icon:String
){
    override fun toString(): String {
        return "Clima: $main ($description) \n ID: $id \n Icono: $icon"
    }
}
