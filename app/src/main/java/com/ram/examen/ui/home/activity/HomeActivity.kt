package com.ram.examen.ui.home.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.ram.examen.R
import com.ram.examen.di.Result
import com.ram.examen.ui.home.fragment.CalculateFragment
import com.ram.examen.ui.home.fragment.CalculateFragmentDirections
import com.ram.examen.ui.home.fragment.HomeFragment
import com.ram.examen.ui.home.fragment.HomeFragmentDirections

class HomeActivity : AppCompatActivity(), HomeFragment.HomeListener, CalculateFragment.CalculateListener {

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

    override fun onDoResult(result: Result) {
        findNavController(R.id.navHostFragment).navigate(
            CalculateFragmentDirections.actionCalculateFragmentToResultFragment(result)
        )
    }

    companion object {
        const val SUM = 1
        const val SUBTRACTION = 2
        const val MULTIPLICATION = 3

    }

}