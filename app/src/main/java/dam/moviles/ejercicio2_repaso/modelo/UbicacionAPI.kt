package dam.moviles.ejercicio2_repaso.modelo

import retrofit2.http.GET
import retrofit2.http.Query

interface UbicacionAPI {
    @GET("direct")
    suspend fun consultarUbicacion(
        @Query("q") q:String,
        @Query("appid") appid:String="3fa9bfaf957e02d2f5520823abd938e2",
        @Query("limit") limit:Int = 5
    ):List<Ubicacion>
}