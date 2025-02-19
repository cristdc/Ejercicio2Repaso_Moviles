package dam.moviles.ejercicio2_repaso.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import dam.moviles.ejercicio2_repaso.R
import dam.moviles.ejercicio2_repaso.databinding.FragmentLugaresBinding
import dam.moviles.ejercicio2_repaso.databinding.FragmentTiempoBinding
import dam.moviles.ejercicio2_repaso.modelo.DatosTiempo
import dam.moviles.ejercicio2_repaso.modelo.Tiempo
import dam.moviles.ejercicio2_repaso.modelo.TiempoRepository
import kotlinx.coroutines.launch


class TiempoFragment : Fragment() {

    var _binding: FragmentTiempoBinding?=null
    val binding: FragmentTiempoBinding
        get()= checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater,container)
        rellenar()
        return binding.root
    }

    private fun rellenar(){
        lifecycleScope.launch {
            val mensaje = TiempoFragmentArgs.fromBundle(requireArguments()).ubicacionSeleccionada
            binding.txtNombre.text = mensaje.name

            val tiempo: Tiempo = TiempoRepository().consultarTiempo(mensaje.lat,mensaje.lon)
            binding.txtHumedad.text=tiempo.current.humidity.toString()
            binding.txtPresion.text=tiempo.current.pressure.toString()
            binding.txtVelocidadViento.text=tiempo.current.wind_speed.toString()
            binding.txtTemperatura.text=tiempo.current.temp.toString()
            binding.txtResumen.text=tiempo.current.weather.toString()
            Log.d("caca","${mensaje.name} yy ${mensaje.lat} yy ")
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        _binding= FragmentTiempoBinding.inflate(inflater,container,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}