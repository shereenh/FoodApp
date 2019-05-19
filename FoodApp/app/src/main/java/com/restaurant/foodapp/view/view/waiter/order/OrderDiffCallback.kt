package com.restaurant.foodapp.view.view.waiter.order

import androidx.recyclerview.widget.DiffUtil
import com.restaurant.foodapp.view.view.waiter.order.OrderAction

class OrderDiffCallback(private val oldList: ArrayList<OrderAction>, private val newList: ArrayList<OrderAction>): DiffUtil.Callback() {

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        return oldList[oldItemPosition].orderItem.id.compareTo(newList[newItemPosition].orderItem.id) == 0
    }

    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldItem = oldList[oldItemPosition]
        val newItem = newList[newItemPosition]
        val first = oldItem.orderItem.table == newItem.orderItem.table
        val second = oldItem.showMenu == newItem.showMenu
        val third = oldItem.showMenuButtonEnabled == newItem.showMenuButtonEnabled
        val fourth = oldItem.showTableCreation == newItem.showTableCreation

        return first && second && third && fourth
    }
}