package com.example.finalprojectfoodapp.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.finalprojectfoodapp.databinding.FragmentCartBinding
import com.example.finalprojectfoodapp.ui.adapter.SepetAdapter
import com.example.finalprojectfoodapp.ui.viewmodel.CartFragmentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CartFragment : Fragment() {

    private lateinit var binding: FragmentCartBinding
    private lateinit var adapter: SepetAdapter
    private val viewModel: CartFragmentViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCartBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val viewModel: CartFragmentViewModel by activityViewModels()
        binding.recyclerViewCart.layoutManager = LinearLayoutManager(requireContext())
        adapter = SepetAdapter(emptyList(), viewModel) {
            binding.textViewTotlPriceCart.text = "${viewModel.getToplamFiyat()} ₺"
        }

        binding.recyclerViewCart.adapter = adapter

        viewModel.sepetYemekler.observe(viewLifecycleOwner) { liste ->
            val adapter = SepetAdapter(liste, viewModel) {
                binding.textViewTotlPriceCart.text = "${viewModel.getToplamFiyat()} ₺"
            }
            binding.recyclerViewCart.adapter = adapter
        }


        binding.textViewTotlPriceCart.text = viewModel.getToplamFiyat().toString() + " ₺"
    }
}
