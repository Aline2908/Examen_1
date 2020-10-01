package com.ram.examen.ui.home.fragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ram.examen.databinding.FragmentHomeBinding
import com.ram.examen.ui.home.activity.HomeActivity

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

    private var listener: HomeListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? HomeListener
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initClickListener()
    }

    fun initClickListener() {
        binding.buttonPlus.setOnClickListener { v ->
            listener?.onDoCalculate(HomeActivity.SUM)
        }
        binding.buttonSubtraction.setOnClickListener { v ->
            listener?.onDoCalculate(HomeActivity.SUBTRACTION)
        }
        binding.buttonMultiplication.setOnClickListener { v ->
            listener?.onDoCalculate(HomeActivity.MULTIPLICATION)
        }
    }

    interface HomeListener {
        fun onDoCalculate(calculate: Int)
    }
}