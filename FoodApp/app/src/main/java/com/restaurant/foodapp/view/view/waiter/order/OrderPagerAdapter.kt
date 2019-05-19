package com.restaurant.foodapp.view.view.waiter.order

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.restaurant.foodapp.databinding.ItemOrderBinding

class OrderPagerAdapter(orderList: ArrayList<OrderItem>, context: Context):
    RecyclerView.Adapter<OrderPagerAdapter.ViewHolder>(), OrderAction.ChangeCallback{

    var mContext = context
    var mOrderActionList = ArrayList<OrderAction>()
    var mOldList = ArrayList<OrderAction>()

    init {
        for(item in orderList){
            mOrderActionList.add(OrderAction(item))
            mOldList.add(OrderAction(item))
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemOrderBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding, mContext, this)

    }

    override fun getItemCount() = mOrderActionList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val orderItem = mOrderActionList[position]
        holder.binding.action = orderItem
        holder.binder()
    }

    fun setOrders(newData: ArrayList<OrderItem>){
      mOrderActionList.clear()
        for(item in newData){
            mOrderActionList.add(OrderAction(item))
        }
        notifyDataSetChanged()
    }

    fun deleteOrderAt(position: Int){
        mOrderActionList.removeAt(position)

//        val diffCallback = OrderDiffCallback(mOldList, mOldList)
//        val diffResult = DiffUtil.calculateDiff(diffCallback)
//
//        mOldList.removeAt(position)
//
//        diffResult.dispatchUpdatesTo(this)

        notifyDataSetChanged()
    }

    fun deleteOrder(orderId: String){
        var index = -1
        for(i in 0 until mOrderActionList.size){
            if(mOrderActionList[i].orderItem.id == orderId){
                index = i
            }
        }

        if(index != -1){
            mOrderActionList.removeAt(index)
            notifyDataSetChanged()
        }
    }

    fun addOrder(item: OrderItem){

        mOrderActionList.add(OrderAction(item))
        notifyDataSetChanged()
    }

    class ViewHolder(var binding: ItemOrderBinding, private var context: Context, private var instance: OrderPagerAdapter): RecyclerView.ViewHolder(binding.root){

        fun binder() {
            binding.action!!.setters(binding.root, context, instance)
        }
    }

    override fun changeRegistered(){
        notifyDataSetChanged()
    }

    override fun deleteOrderRegistered(orderId: String){
        deleteOrder(orderId)
    }
}