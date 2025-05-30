package com.example.finalprojectfoodapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalprojectfoodapp.data.entity.SepetYemek
import com.example.finalprojectfoodapp.databinding.CartTasarimBinding
import com.example.finalprojectfoodapp.ui.viewmodel.CartFragmentViewModel

class SepetAdapter(
    private var sepetList: List<SepetYemek>,
    private val cartViewModel: CartFragmentViewModel,
    private val onCartChanged: () -> Unit
) : RecyclerView.Adapter<SepetAdapter.SepetViewHolder>() {

    class SepetViewHolder(val binding: CartTasarimBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SepetViewHolder {
        val binding = CartTasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return SepetViewHolder(binding)
    }

    override fun onBindViewHolder(holder: SepetViewHolder, position: Int) {
        val item = sepetList[position]
        with(holder.binding) {
            textViewFoodName.text = item.yemekAdi
            textViewPriceOfOneFoodInCart.text = "Fiyat: ${item.yemekFiyat} ₺"
            textViewFoodCount.text = "Adet: ${item.yemekSiparisAdet}"

            val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${item.yemekResimAdi}"
            Glide.with(imageView2.context).load(imageUrl).into(imageView2)
            textViewTotalPriceCart.text = (item.yemekSiparisAdet * item.yemekFiyat).toString() + " ₺"
            imageButtonDeleteCart.setOnClickListener {
                cartViewModel.sepettenCikar(item.sepetYemekId)
                onCartChanged()
            }
        }
    }

    override fun getItemCount(): Int = sepetList.size
}
