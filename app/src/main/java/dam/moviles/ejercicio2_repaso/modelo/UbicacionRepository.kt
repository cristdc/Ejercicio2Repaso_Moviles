package dam.moviles.ejercicio2_repaso.modelo

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

class UbicacionRepository {
    val ubicacionAPI:UbicacionAPI
    init{
        ubicacionAPI=Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/geo/1.0/")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create()
    }

    suspend fun consultarUbicacion(q:String):List<Ubicacion> = ubicacionAPI.consultarUbicacion(q,"3fa9bfaf957e02d2f5520823abd938e2",5)
}