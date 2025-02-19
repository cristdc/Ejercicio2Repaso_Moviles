package dam.moviles.ejercicio2_repaso.vista

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dam.moviles.ejercicio2_repaso.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        inicializarBinding()
        setContentView(binding.root)
    }

    private fun inicializarBinding() {
        binding=ActivityMainBinding.inflate(layoutInflater)
    }
}