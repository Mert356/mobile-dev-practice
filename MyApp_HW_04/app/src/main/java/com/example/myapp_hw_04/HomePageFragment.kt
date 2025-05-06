package com.example.myapp_hw_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapp_hw_04.databinding.FragmentHomePageBinding


class HomePageFragment : Fragment() {
    private lateinit var binding: FragmentHomePageBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomePageBinding.inflate(inflater, container, false)
        binding.buttonToGoA.setOnClickListener {
            val action = HomePageFragmentDirections.actionHomePageFragmentToPageAFragment()
            Navigation.findNavController(it).navigate(action)
        }

        binding.buttonToGoX.setOnClickListener {
            val action = HomePageFragmentDirections.actionHomePageFragmentToPageXFragment()
            Navigation.findNavController(it).navigate(action)
        }
        return binding.root
    }

}