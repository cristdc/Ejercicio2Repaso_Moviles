package dam.moviles.ejercicio2_repaso.vista

import androidx.recyclerview.widget.RecyclerView
import dam.moviles.ejercicio2_repaso.databinding.UbicacionBinding
import dam.moviles.ejercicio2_repaso.modelo.Ubicacion

class UbicacionHolder(val binding: UbicacionBinding)
    : RecyclerView.ViewHolder(binding.root) {
    lateinit var ubicacion: Ubicacion

    fun mostrarUbicacion(u: Ubicacion) {
        ubicacion=u
        binding.txtPais.text=u.country
        binding.txtLongitud.text= u.lon.toString()
        binding.txtLatitud.text=u.lat.toString()
        binding.txtNombre.text=u.name
    }
}