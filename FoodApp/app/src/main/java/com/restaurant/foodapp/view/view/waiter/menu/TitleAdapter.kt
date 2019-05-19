package com.restaurant.foodapp.view.view.waiter.menu

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.restaurant.foodapp.databinding.ItemTitleBinding
import kotlinx.android.synthetic.main.item_title.view.*

class TitleAdapter(var titleList: ArrayList<TitleItem>, var mContext: Context):  RecyclerView.Adapter<TitleAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TitleAdapter.ViewHolder {
        val binding = ItemTitleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TitleAdapter.ViewHolder(binding, mContext, this)
    }

    override fun getItemCount() = titleList.size

    override fun onBindViewHolder(holder: TitleAdapter.ViewHolder, position: Int) {
        val item = titleList[position]
        holder.binding.title = item

        holder.binding.root.subRecycler.layoutManager = LinearLayoutManager(mContext)
        val adapter = MenuAdapter(item.menuList)
        holder.binding.root.subRecycler.adapter = adapter
    }

    class ViewHolder(var binding: ItemTitleBinding, var context: Context, var instance: TitleAdapter): RecyclerView.ViewHolder(binding.root){

    }
}