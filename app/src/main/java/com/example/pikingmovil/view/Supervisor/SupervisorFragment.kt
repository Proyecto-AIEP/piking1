package com.example.pikingmovil.view.Supervisor

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pikingmovil.R
import com.example.pikingmovil.databinding.FragmentAdminBinding
import com.example.pikingmovil.databinding.FragmentSupervisorBinding


class SupervisorFragment : Fragment() {

    private var _binding: FragmentSupervisorBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSupervisorBinding.inflate(inflater,container,false)
        return binding.root
    }
}
