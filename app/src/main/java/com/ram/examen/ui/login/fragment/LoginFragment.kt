package com.ram.examen.ui.login.fragment

import android.content.Context
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
import com.ram.examen.di.UserInfo

class LoginFragment : Fragment() {

    lateinit var binding: FragmentLoginBinding

    private var listener: LoginListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        listener = context as? LoginListener
    }

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
        binding.apply {
            edittextUser.setText("Aline")
            edittextPassword.setText("")
            buttonAccept.setOnClickListener { v ->
//                Navigation.findNavController(v).navigate(R.id.welcomeFragment)
                doLogin()
            }
        }
    }

    fun doLogin() {
        val userInfo = UserInfo(
            binding.edittextUser.text.toString(),
            binding.edittextPassword.text.toString()
        )
        listener?.onDoLogin(userInfo)
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
                if (binding.edittextUser.getText().toString().trim().length == 5
                    && binding.edittextPassword.getText().toString().trim()
                        .length == 4
                ) {
                    changeBackground(true)
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

    interface LoginListener {
        fun onDoLogin(userInfo: UserInfo)
    }

}