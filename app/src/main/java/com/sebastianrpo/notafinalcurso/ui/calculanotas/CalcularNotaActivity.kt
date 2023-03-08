package com.sebastianrpo.notafinalcurso.ui.calculanotas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.sebastianrpo.notafinalcurso.R
import com.sebastianrpo.notafinalcurso.databinding.ActivityCalcularNotaBinding
import com.sebastianrpo.notafinalcurso.databinding.ActivitySplashBinding

class CalcularNotaActivity : AppCompatActivity() {
    private lateinit var calcularNotabinding : ActivityCalcularNotaBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        calcularNotabinding = ActivityCalcularNotaBinding.inflate(layoutInflater)
        val view = calcularNotabinding.root
        setContentView(view)
        calcularNotabinding.calcularButton.setOnClickListener{
            var nota1 = calcularNotabinding.nota1EditText.text.toString().toDouble()*0.6
            var nota2 = calcularNotabinding.nota2EditText.text.toString().toDouble()*0.07
            var nota3 = calcularNotabinding.nota3EditText.text.toString().toDouble()*0.08
            var nota4 = calcularNotabinding.nota4EditText.text.toString().toDouble()*0.25
            val resultado = nota1+nota2+nota3+nota4
            val info = "Nota final: $resultado"
            calcularNotabinding.notaFinalTextView.setText(info) //Version 1
        }
    }
}