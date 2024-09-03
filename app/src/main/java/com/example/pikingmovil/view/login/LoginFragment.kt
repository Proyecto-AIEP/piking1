package com.example.pikingmovil.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.pikingmovil.R
import com.example.pikingmovil.databinding.FragmentLoginBinding

class LoginFragment : Fragment() {

    private var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.loginButtom.setOnClickListener {
            val username = binding.UserEditText.text.toString()
            val password = binding.PasswordEditText.text.toString()

            authenticateUser(username, password)
        }
    }

    private fun authenticateUser(username: String, password: String) {

        val userRole = when (username) {
            "admin" -> "admin"
            "supervisor" -> "supervisor"
            "logistica" -> "logistica"
            "picker" -> "picker"
            else -> "unknown"
        }

        if (userRole != "unknown") {
            navigateToRoleFragment(userRole)
        } else {
            Toast.makeText(requireContext(), "Usuario o contraseña incorrectos", Toast.LENGTH_SHORT).show()
        }
    }

    private fun navigateToRoleFragment(role: String) {
        val action = when (role) {
            "admin" -> R.id.action_loginFragment_to_adminFragment
            "supervisor" -> R.id.action_loginFragment_to_supervisorFragment
            "logistica" -> R.id.action_loginFragment_to_logisticaFragment
            "picker" -> R.id.action_loginFragment_to_pickerFragment
            else -> null
        }

        action?.let {
            findNavController().navigate(it)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
