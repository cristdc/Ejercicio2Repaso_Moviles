package dam.moviles.ejercicio2_repaso.vista

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dam.moviles.ejercicio2_repaso.R
import dam.moviles.ejercicio2_repaso.databinding.FragmentInicioBinding

class InicioFragment : Fragment() {

    var _binding:FragmentInicioBinding?=null
    val binding:FragmentInicioBinding
        get()= checkNotNull(_binding)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inicializarBinding(inflater,container)
        navegar()
        return binding.root
    }

    private fun navegar(){
        binding.btnBuscar.setOnClickListener {
            val navigationController = findNavController()
            val accion = InicioFragmentDirections.actionInicioFragmentToLugaresFragment(binding.txtLugarIntroducido.text.toString())
            navigationController.navigate(accion)
        }
    }

    private fun inicializarBinding(inflater: LayoutInflater, container: ViewGroup?) {
        _binding=FragmentInicioBinding.inflate(inflater,container,false)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding=null
    }

}