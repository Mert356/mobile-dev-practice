package com.example.myapp_hw_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapp_hw_04.databinding.FragmentPageBBinding


class PageBFragment : Fragment() {

    private lateinit var binding: FragmentPageBBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPageBBinding.inflate(inflater, container, false)
        binding.buttonToGoY.setOnClickListener {
            val action = PageBFragmentDirections.actionPageBFragmentToPageYFragment()
            Navigation.findNavController(it).navigate(action)
        }
        return binding.root
    }

}