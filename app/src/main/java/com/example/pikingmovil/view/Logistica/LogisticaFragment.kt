package com.example.pikingmovil.view.Logistica

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pikingmovil.databinding.FragmentLogisticaBinding

class LogisticaFragment : Fragment() {

    private var _binding: FragmentLogisticaBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLogisticaBinding.inflate(inflater,container,false)
        return binding.root
    }
}