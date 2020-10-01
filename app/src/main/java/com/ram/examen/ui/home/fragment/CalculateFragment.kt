package com.ram.examen.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ram.examen.R
import com.ram.examen.databinding.FragmentCalculateBinding
import com.ram.examen.ui.home.activity.HomeActivity

class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding

    private val args: CalculateFragmentArgs by navArgs()

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
        initClickListener()
        updateCopies()
    }

    fun initClickListener() {
        binding.buttonCalculate.setOnClickListener { v ->
            showError()
        }
    }

    fun updateCopies() {
        val operation = args.operation
        when (operation) {
            HomeActivity.SUM -> {
               binding.buttonCalculate.text = resources.getString(R.string.home_button_calculate_sum)
            }
            HomeActivity.SUBTRACTION -> {
                binding.buttonCalculate.text = resources.getString(R.string.home_button_calculate_subtraction)
            }
            HomeActivity.MULTIPLICATION -> {
                binding.buttonCalculate.text = resources.getString(R.string.home_button_calculate_multiplication)
            }
        }
    }

    fun showError() {
        if (binding.edittextValue1.text.isEmpty() || binding.edittextValue2.text.isEmpty() ) {
            Toast.makeText(context, "Ingresa ambos campos", Toast.LENGTH_SHORT).show()
        }
    }
}