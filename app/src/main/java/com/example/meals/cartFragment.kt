package com.example.meals

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meals.databinding.FragmentCartBinding

class cartFragment : Fragment() {

    lateinit var binding: FragmentCartBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentCartBinding.inflate(inflater, container, false)

        return binding.root
    }
}