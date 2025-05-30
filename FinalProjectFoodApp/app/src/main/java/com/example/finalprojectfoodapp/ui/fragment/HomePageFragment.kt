package com.example.finalprojectfoodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalprojectfoodapp.databinding.FragmentHomePageBinding
import com.example.finalprojectfoodapp.ui.adapter.YemekAdapter
import com.example.finalprojectfoodapp.ui.viewmodel.HomePageViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePageFragment : Fragment() {

    private var _binding: FragmentHomePageBinding? = null
    private val binding get() = _binding!!
    private val viewModel: HomePageViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.recyclerView.layoutManager = GridLayoutManager(requireContext(), 2)

        viewModel.yemekler.observe(viewLifecycleOwner) { yemekList ->
            binding.recyclerView.adapter = YemekAdapter(yemekList) { secilenYemek ->
                // Navigation Directions ile Yemek nesnesini gönder
                val action = HomePageFragmentDirections
                    .actionHomePageFragmentToDetailFragment(secilenYemek)
                findNavController().navigate(action)
            }
        }
        binding.fabCart.setOnClickListener {
            val action = HomePageFragmentDirections.actionHomePageFragmentToCartFragment()
            findNavController().navigate(action)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
