package com.example.myapp_hw_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapp_hw_04.databinding.FragmentPageABinding

class PageAFragment : Fragment() {
    private lateinit var binding: FragmentPageABinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPageABinding.inflate(inflater, container, false)

        binding.buttonToGoB.setOnClickListener {
            val action = PageAFragmentDirections.actionPageAFragmentToPageBFragment()
            Navigation.findNavController(it).navigate(action)
        }

        return binding.root
    }
}