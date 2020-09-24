package com.ram.examen.ui.activity.login.fragment

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.ram.examen.R
import com.ram.examen.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    var user: String = ""
    var password: String = ""
    var isLogin: Boolean = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        onTextChange()
    }

    fun initView() {
        if (isLogin) {
            binding.edittextUser.setText(user)
            binding.edittextPassword.setText(password)
        }
        binding.buttonAccept.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.welcomeFragment)
        }
    }

    fun onTextChange() {
        initChangeListener(binding.edittextUser)
        initChangeListener(binding.edittextPassword)
    }

    fun initChangeListener(editText: EditText) {
        editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(
                s: CharSequence,
                start: Int,
                count: Int,
                after: Int
            ) {
            }
            override fun onTextChanged(
                s: CharSequence,
                start: Int,
                before: Int,
                count: Int
            ) {
                if (isLogin) {
                    if (binding.edittextUser.getText().toString().trim().length == 5
                        && binding.edittextPassword.getText().toString().trim()
                            .length == 4
                    ) {
                        changeBackground(true)
                    } else {
                        changeBackground(false)
                    }
                } else {
                    changeBackground(false)
                }
            }
            override fun afterTextChanged(s: Editable) {}
        })
    }

    fun changeBackground(isOn: Boolean) {
        if (isOn) {
            binding.buttonAccept.background = resources.getDrawable(R.drawable.bg_button)
            binding.buttonAccept.isEnabled = true
        } else {
            binding.buttonAccept.background = resources.getDrawable(R.drawable.bg_button_disabled)
            binding.buttonAccept.isEnabled = false
        }
    }

}