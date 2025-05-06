package com.example.myapp_hw_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewbinding.ViewBinding
import com.example.myapp_hw_04.databinding.FragmentPageYBinding

class PageYFragment : Fragment() {

    private lateinit var binding: FragmentPageYBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = FragmentPageYBinding.inflate(inflater, container, false)
        return binding.root
    }

}