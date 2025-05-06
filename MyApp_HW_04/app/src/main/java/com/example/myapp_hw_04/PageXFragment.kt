package com.example.myapp_hw_04

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.example.myapp_hw_04.databinding.FragmentPageXBinding

class PageXFragment : Fragment() {
    private lateinit var binding: FragmentPageXBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPageXBinding.inflate(inflater, container, false)
        binding.buttonToGoYFromX.setOnClickListener {
            val action = PageXFragmentDirections.actionPageXFragmentToPageYFragment()
            Navigation.findNavController(it).navigate(action)
        }
        return binding.root
    }

}