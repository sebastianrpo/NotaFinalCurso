package com.sebastianrpo.notafinalcurso.ui.calculanotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.sebastianrpo.notafinalcurso.databinding.ActivityCalcularNotaBinding
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.notafinalcurso.R

class CalcularNotaActivity : AppCompatActivity() {
    private lateinit var calcularNotaBinding: ActivityCalcularNotaBinding
    private lateinit var calcularNotaViewModel: CalcularNotaViewModel
    private var nota1: Double = 0.0
    private var nota2: Double = 0.0
    private var nota3: Double = 0.0
    private var nota4: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        calcularNotaBinding = ActivityCalcularNotaBinding.inflate(layoutInflater)
        calcularNotaViewModel = ViewModelProvider(this)[CalcularNotaViewModel::class.java]
        val view = calcularNotaBinding.root
        setContentView(view)

        val resultadoObserver = Observer<Double> { resultado ->
            calcularNotaBinding.notaFinalTextView.text = resultado.toString()
        }

        calcularNotaViewModel.resultado.observe(this, resultadoObserver)

        calcularNotaBinding.calcularButton.setOnClickListener {
            if (calcularNotaViewModel.validarNotasNulas(
                    calcularNotaBinding.nota1EditText.text.toString(),
                    calcularNotaBinding.nota2EditText.text.toString(),
                    calcularNotaBinding.nota3EditText.text.toString(),
                    calcularNotaBinding.nota4EditText.text.toString()
                )
            ) {
                leerDatos()
                if (calcularNotaViewModel.validarNotasIncorrectas(nota1, nota2, nota3, nota4)) {
                    calcularNotaViewModel.resultado(nota1, nota2, nota3, nota4)
                } else {
                    Toast.makeText(this, getString(R.string.nota_incorrecta), Toast.LENGTH_SHORT).show()
                    calcularNotaBinding.notaFinalTextView.text = getString(R.string.nota_final)
                }
            } else {
                Toast.makeText(this, getString(R.string.nota_blanco), Toast.LENGTH_SHORT).show()
                calcularNotaBinding.notaFinalTextView.text = getString(R.string.nota_final)
            }
        }
    }

    private fun leerDatos() {
        nota1 = calcularNotaBinding.nota1EditText.text.toString().toDouble()
        nota2 = calcularNotaBinding.nota2EditText.text.toString().toDouble()
        nota3 = calcularNotaBinding.nota3EditText.text.toString().toDouble()
        nota4 = calcularNotaBinding.nota4EditText.text.toString().toDouble()
    }
}