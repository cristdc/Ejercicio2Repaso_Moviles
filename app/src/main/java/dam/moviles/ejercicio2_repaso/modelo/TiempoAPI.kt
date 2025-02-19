package dam.moviles.ejercicio2_repaso.modelo

import retrofit2.http.GET
import retrofit2.http.Query

interface TiempoAPI {
    @GET("onecall")
    suspend fun consultarTiempo(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("exclude") exclude: String = "minutely,hourly,daily,alerts",
        @Query("appid") appid: String = "3fa9bfaf957e02d2f5520823abd938e2",
        @Query("units") units: String = "metric",
        @Query("lang") lang: String = "es"
    ): Tiempo
}