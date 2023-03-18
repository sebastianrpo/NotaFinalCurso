package com.sebastianrpo.notafinalcurso.ui.calculanotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.sebastianrpo.notafinalcurso.databinding.ActivityCalcularNotaBinding
import androidx.lifecycle.ViewModelProvider
import com.sebastianrpo.notafinalcurso.R

class CalcularNotaActivity : AppCompatActivity() {
    private lateinit var calcularNotabinding: ActivityCalcularNotaBinding
    private lateinit var calcularNotaViewModel: CalcularNotaViewModel
    private var nota1: Double = 0.0
    private var nota2: Double = 0.0
    private var nota3: Double = 0.0
    private var nota4: Double = 0.0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        calcularNotabinding = ActivityCalcularNotaBinding.inflate(layoutInflater)
        calcularNotaViewModel = ViewModelProvider(this)[CalcularNotaViewModel::class.java]
        val view = calcularNotabinding.root
        setContentView(view)

        val resultadoObserver = Observer<Double> { resultado ->
            calcularNotabinding.notaFinalTextView.text = resultado.toString()
        }

        calcularNotaViewModel.resultado.observe(this, resultadoObserver)

        calcularNotabinding.calcularButton.setOnClickListener {
            if (calcularNotaViewModel.validarNotasNulas(
                    calcularNotabinding.nota1EditText.text.toString(),
                    calcularNotabinding.nota2EditText.text.toString(),
                    calcularNotabinding.nota3EditText.text.toString(),
                    calcularNotabinding.nota4EditText.text.toString()
                )
            ) {
                leerDatos()
                if (calcularNotaViewModel.validarNotasIncorrectas(nota1, nota2, nota3, nota4)) {
                    calcularNotaViewModel.resultado(nota1, nota2, nota3, nota4)
                } else {
                    Toast.makeText(this, getString(R.string.nota_incorrecta), Toast.LENGTH_SHORT)
                        .show()
                    calcularNotabinding.notaFinalTextView.text = ""
                }
            } else {
                Toast.makeText(this, getString(R.string.nota_blanco), Toast.LENGTH_SHORT).show()
                calcularNotabinding.notaFinalTextView.text = ""
            }
        }
    }

    private fun leerDatos() {
        nota1 = calcularNotabinding.nota1EditText.text.toString().toDouble()
        nota2 = calcularNotabinding.nota2EditText.text.toString().toDouble()
        nota3 = calcularNotabinding.nota3EditText.text.toString().toDouble()
        nota4 = calcularNotabinding.nota4EditText.text.toString().toDouble()
    }
}