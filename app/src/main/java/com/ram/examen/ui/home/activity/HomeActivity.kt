package com.ram.examen.ui.home.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.ram.examen.R
import com.ram.examen.di.Calculate
import com.ram.examen.ui.home.fragment.HomeFragment
import com.ram.examen.ui.home.fragment.HomeFragmentDirections

class HomeActivity : AppCompatActivity(), HomeFragment.HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }

    override fun onDoCalculate(calculate: Int) {
        Log.i("Aline_", "DoCalculate")
        findNavController(R.id.navHostFragment).navigate(
            HomeFragmentDirections.actionHomeFragmentToCalculateFragment(calculate)
        )
    }

    companion object {
        const val SUM = 1
        const val SUBTRACTION = 2
        const val MULTIPLICATION = 3
    }
}