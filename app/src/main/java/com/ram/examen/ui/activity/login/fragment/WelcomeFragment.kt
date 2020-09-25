package com.ram.examen.ui.activity.login.fragment

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ram.examen.databinding.FragmentWelcomeBinding
import com.ram.examen.ui.activity.home.HomeActivity
import com.ram.examen.ui.activity.home.fragment.HomeFragment

class WelcomeFragment : Fragment() {

    lateinit var binding: FragmentWelcomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentWelcomeBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        launchHome()
    }

    fun launchHome() {
        Handler().postDelayed({
            val intent = Intent(requireContext(), HomeActivity::class.java)
            startActivity(intent)
        }, 3000)
    }
}