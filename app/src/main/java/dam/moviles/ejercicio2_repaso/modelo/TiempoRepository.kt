package dam.moviles.ejercicio2_repaso.modelo

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class TiempoRepository {
    val tiempoAPI:TiempoAPI
    init{
        tiempoAPI= Retrofit.Builder()
            .baseUrl("https://api.openweathermap.org/data/2.8/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    suspend fun consultarTiempo(lat:Double,lon:Double):Tiempo =
        tiempoAPI.consultarTiempo(
            lat,
            lon,
            "minutely,hourly,daily,alerts",
            "3fa9bfaf957e02d2f5520823abd938e2",
            "metric",
            "es")

}