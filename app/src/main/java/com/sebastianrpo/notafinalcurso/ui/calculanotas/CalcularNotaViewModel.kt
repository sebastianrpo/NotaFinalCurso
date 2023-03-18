package com.sebastianrpo.notafinalcurso.ui.calculanotas

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CalcularNotaViewModel : ViewModel() {

    val resultado:MutableLiveData<Double> by lazy {
        MutableLiveData<Double>()
    }

    fun resultado(nota1: Double, nota2: Double, nota3: Double, nota4: Double) {
        resultado.value = nota1*0.6+nota2*0.07+nota3*0.08+nota4*0.25
    }

    fun validarNotasIncorrectas(nota1: Double, nota2: Double, nota3: Double, nota4: Double): Boolean {
        return (nota1 >= 0 && nota1 <= 5 && nota2 >= 0 && nota2 <= 5 && nota3 >= 0 && nota3 <= 5 && nota4 >= 0 && nota4 <= 5)
        }

    fun validarNotasNulas(nota1: String, nota2: String, nota3: String, nota4: String): Boolean{
        return !(nota1.isEmpty() || nota2.isEmpty() || nota3.isEmpty() || nota4.isEmpty())
    }
    }