package com.ram.examen.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.ram.examen.databinding.FragmentCalculateBinding

class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCalculateBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        calculate()
        calculatePlus()
    }

    fun calculate() {
        binding.buttonCalculate.setOnClickListener { v ->
            showError()
        }
    }

    fun calculatePlus() {
        var x = 2.1
        var y = 3
        //Área de una esfera
        //4*PI*r2
        System.out.println(4 * Math.PI * Math.pow(x, 2.0))
    }

    fun showError() {
        if (binding.edittextValue1.text.isEmpty() || binding.edittextValue2.text.isEmpty() ) {
            Toast.makeText(context, "Ingresa ambos campos", Toast.LENGTH_SHORT).show()
        }
    }
}