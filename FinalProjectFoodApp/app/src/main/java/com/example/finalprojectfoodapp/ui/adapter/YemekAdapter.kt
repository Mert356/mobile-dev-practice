package com.example.finalprojectfoodapp.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.finalprojectfoodapp.data.entity.Yemek
import com.example.finalprojectfoodapp.databinding.TasarimBinding

class YemekAdapter(
    private val yemekList: List<Yemek>,
    private val onYemekClick: (Yemek) -> Unit
) : RecyclerView.Adapter<YemekAdapter.YemekViewHolder>() {

    class YemekViewHolder(val binding: TasarimBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): YemekViewHolder {
        val binding = TasarimBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return YemekViewHolder(binding)
    }

    override fun onBindViewHolder(holder: YemekViewHolder, position: Int) {
        val yemek = yemekList[position]

        holder.binding.textViewYemekAd.text = yemek.ad
        holder.binding.textViewYemekFiyat.text = "${yemek.fiyat} ₺"
        val imageUrl = "http://kasimadalan.pe.hu/yemekler/resimler/${yemek.resimAdi}"
        Glide.with(holder.itemView.context).load(imageUrl).into(holder.binding.imageViewYemek)

        // Tıklama olayını tanımla
        holder.itemView.setOnClickListener {
            onYemekClick(yemek)
        }
    }

    override fun getItemCount(): Int = yemekList.size
}
