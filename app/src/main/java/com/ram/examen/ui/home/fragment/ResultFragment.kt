package com.ram.examen.ui.home.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.ram.examen.databinding.FragmentResultBinding
import com.ram.examen.ui.home.activity.HomeActivity

class ResultFragment : Fragment() {

    lateinit var binding: FragmentResultBinding

    private val args: ResultFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentResultBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchHome()
        setResult()
    }

    private fun setResult() {
        binding.textviewResult.text = args.result.result.toString()
    }

    fun launchHome() {
        Handler().postDelayed({
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}