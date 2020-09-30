package com.ram.examen.ui.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ram.examen.R
import com.ram.examen.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    lateinit var binding: FragmentHomeBinding

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
        initOnClickListener()
    }

    fun initOnClickListener() {
        binding.buttonPlus.setOnClickListener { v ->

            Navigation.findNavController(v).navigate(R.id.calculateFragment)
        }
        binding.buttonSubtraction.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.calculateFragment)
        }
        binding.buttonMultiplication.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.calculateFragment)
        }
    }
}