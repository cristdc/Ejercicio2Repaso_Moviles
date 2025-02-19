package dam.moviles.ejercicio2_repaso.vista

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import dam.moviles.ejercicio2_repaso.databinding.UbicacionBinding
import dam.moviles.ejercicio2_repaso.modelo.Ubicacion

class UbicacionAdapter (
    var ubicacion: List<Ubicacion>,
    val lambda:(UbicacionHolder) -> Unit
):RecyclerView.Adapter<UbicacionHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UbicacionHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = UbicacionBinding.inflate(inflater,parent,false)
        return UbicacionHolder(binding)
    }

    override fun getItemCount(): Int =ubicacion.size

    override fun onBindViewHolder(holder: UbicacionHolder, position: Int) {
        val ubicacion = ubicacion.get(position)
        holder.mostrarUbicacion(ubicacion)
        holder.binding.root.setOnClickListener {
            lambda(holder)
        }
    }
}