package dam.moviles.ejercicio2_repaso.vista

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import dam.moviles.ejercicio2_repaso.databinding.FragmentLugaresBinding
import dam.moviles.ejercicio2_repaso.modelo.Ubicacion
import dam.moviles.ejercicio2_repaso.modelo.UbicacionRepository
import dam.moviles.ejercicio2_repaso.viewmodel.LugaresFragmentViewModel
import kotlinx.coroutines.launch

class LugaresFragment : Fragment() {

    var _binding: FragmentLugaresBinding? = null
    val binding: FragmentLugaresBinding
        get() = checkNotNull(_binding)
    private lateinit var viewModel: LugaresFragmentViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater, container)
        inicializarViewModel()
        inicializarRecyclerView()
        return binding.root
    }

    private fun inicializarRecyclerView() {
        lifecycleScope.launch {
            val mensaje = LugaresFragmentArgs.fromBundle(requireArguments()).lugar
            val ubicaciones: List<Ubicacion> = UbicacionRepository().consultarUbicacion(mensaje)

            viewModel.ubicaciones = ubicaciones
            Log.d("aaa", viewModel.ubicaciones.toString())
            Log.d("aaa", ubicaciones.toString())

            binding.recycler.adapter = UbicacionAdapter(viewModel.ubicaciones) { u ->
                navegar(u.ubicacion)
            }
        }
    }


    private fun navegar(u:Ubicacion) {
        val navigator = findNavController()
        val accion = LugaresFragmentDirections.actionLugaresFragmentToTiempoFragment(u)
        navigator.navigate(accion)
    }

    private fun inicializarViewModel() {
        viewModel = ViewModelProvider(this).get(LugaresFragmentViewModel::class.java)
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        _binding = FragmentLugaresBinding.inflate(inflater, container, false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}
