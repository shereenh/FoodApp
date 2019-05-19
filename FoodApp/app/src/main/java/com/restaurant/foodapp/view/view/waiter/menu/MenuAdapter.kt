package com.restaurant.foodapp.view.view.waiter.menu

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.restaurant.foodapp.databinding.ItemMenuBinding
import com.restaurant.foodapp.databinding.ItemTitleBinding

class MenuAdapter(var menuList: ArrayList<MenuItem>) : RecyclerView.Adapter<MenuAdapter.ViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuAdapter.ViewHolder {
        val binding = ItemMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MenuAdapter.ViewHolder(binding)
    }

    override fun getItemCount() = menuList.size

    override fun onBindViewHolder(holder: MenuAdapter.ViewHolder, position: Int) {
        val item = menuList[position]
        holder.binding.food = item


    }

    class ViewHolder(var binding: ItemMenuBinding): RecyclerView.ViewHolder(binding.root){

    }
}