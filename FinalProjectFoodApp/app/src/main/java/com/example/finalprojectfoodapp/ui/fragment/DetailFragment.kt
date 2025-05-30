package com.example.finalprojectfoodapp.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.example.finalprojectfoodapp.R
import com.example.finalprojectfoodapp.databinding.FragmentDetailBinding
import com.example.finalprojectfoodapp.ui.viewmodel.CartFragmentViewModel

class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailBinding.inflate(inflater,container,false)

        val  yemek = args.yemek
        binding.textViewPrice.text = yemek.fiyat.toString() + " ₺"
        binding.textViewName.text = yemek.ad.toString()

        val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.resimAdi}"
        Glide.with(requireContext()).load(imageUrl).into(binding.imageView)
        binding.imageButtonClose.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_homePageFragment)
        }
        binding.imageButtonminus.setOnClickListener {
            if(binding.textViewCount.text.toString().toInt() > 0){
                binding.textViewCount.text = (binding.textViewCount.text.toString().toInt() - 1).toString()
                binding.textViewPriceBottom.text = (binding.textViewCount.text.toString().toInt() * yemek.fiyat.toInt()).toString() + "  ₺"
            }
        }

        binding.imageButtonAdd.setOnClickListener {
            binding.textViewCount.text = (binding.textViewCount.text.toString().toInt() + 1).toString()
            binding.textViewPriceBottom.text = (binding.textViewCount.text.toString().toInt() * yemek.fiyat.toInt()).toString() + "  ₺"
        }

        val cartViewModel: CartFragmentViewModel by activityViewModels()
        binding.buttonAddToCart.setOnClickListener {
            val adet = binding.textViewCount.text.toString().toInt()
            if (adet > 0) {
                cartViewModel.sepeteEkle(yemek, adet)
                findNavController().navigate(R.id.action_detailFragment_to_homePageFragment)
            }
        }


        return binding.root
    }



}