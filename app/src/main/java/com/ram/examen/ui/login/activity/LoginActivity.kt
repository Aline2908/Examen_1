package com.ram.examen.ui.login.activity

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import com.ram.examen.R
import com.ram.examen.di.UserInfo
import com.ram.examen.ui.login.fragment.LoginFragment
import com.ram.examen.ui.login.fragment.LoginFragmentDirections

class LoginActivity : AppCompatActivity(), LoginFragment.LoginListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    override fun onDoLogin(userInfo: UserInfo) {
        Log.i("Alin_", "DoLogin")
        findNavController(R.id.navHostFragment)
            .navigate(
                LoginFragmentDirections.actionLoginFragmentToWelcomeFragment(
                    userInfo
                )
            )
    }

}