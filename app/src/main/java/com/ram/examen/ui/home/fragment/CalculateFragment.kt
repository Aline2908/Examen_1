package com.ram.examen.ui.home.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ram.examen.R
import com.ram.examen.databinding.FragmentCalculateBinding
import com.ram.examen.di.Result
import com.ram.examen.ui.home.activity.HomeActivity

class CalculateFragment : Fragment() {

    lateinit var binding: FragmentCalculateBinding

    private var listener: CalculateListener? = null

    private val args: CalculateFragmentArgs by navArgs()

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? HomeActivity
    }

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
            calculate()
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

    fun calculate() {
        var result: Int = 0
        val value1 = binding.edittextValue1.text.toString().toInt()
        val value2 = binding.edittextValue2.text.toString().toInt()
        when (args.operation) {
            HomeActivity.SUM -> {
                result = value1 + value2
            }
            HomeActivity.SUBTRACTION -> {
                result = value1 - value2
            }
            HomeActivity.MULTIPLICATION -> {
                result = value1 * value2
            }
        }
        val totalResult = Result(result)
        listener?.onDoResult(totalResult)
    }

    fun showError() {
        if (binding.edittextValue1.text.isEmpty() || binding.edittextValue2.text.isEmpty() ) {
            Toast.makeText(context, "Ingresa ambos campos", Toast.LENGTH_SHORT).show()
        }
    }

    interface CalculateListener {
        fun onDoResult(result: Result)
    }
}


