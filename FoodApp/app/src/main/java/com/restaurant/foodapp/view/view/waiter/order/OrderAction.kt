package com.restaurant.foodapp.view.view.waiter.order

import android.content.Context
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import com.restaurant.foodapp.view.model.DataSource.sandwichList
import com.restaurant.foodapp.view.model.DataSource.startersNonVegList
import com.restaurant.foodapp.view.model.DataSource.startersVegList
import com.restaurant.foodapp.view.model.DataSource.tableList
import com.restaurant.foodapp.view.view.waiter.menu.TitleAdapter
import com.restaurant.foodapp.view.view.waiter.menu.TitleItem
import kotlinx.android.synthetic.main.item_order.view.*

class OrderAction(orderItem: OrderItem) : AdapterView.OnItemSelectedListener{

    var orderItem = orderItem
    // edit table name visibility
    var showTableCreation = true
    // button enabled
    var showMenuButtonEnabled = false
    // menu visibility
    var showMenu = false

    lateinit var callback : ChangeCallback

    fun setters(view:View, context: Context, callback: ChangeCallback) {
        view.tableSpinner.onItemSelectedListener = this
        val adapter = ArrayAdapter(context, android.R.layout.simple_spinner_item, tableList)
        view.tableSpinner.adapter = adapter
        this.callback = callback

        //menu part

        view.titleRecycler.layoutManager = LinearLayoutManager(context)
        val titleAdapter = TitleAdapter(arrayListOf(TitleItem("Starters - Veg", startersVegList),
            TitleItem("Starters - NonVeg", startersNonVegList),
            TitleItem("Sandwiches", sandwichList)
        )
            , context)
        view.titleRecycler.adapter = titleAdapter
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
//        showMenuButtonEnabled = position != 0
        if(position != 0){
            showMenuButtonEnabled = true
            orderItem.table = "Table $position"
            callback.changeRegistered()
        }else{
            showMenuButtonEnabled = false
        }
    }

    fun showMenuScreen(){
        showTableCreation = false
        showMenu = true
        callback.changeRegistered()
    }

    fun deleteOrder(){
        callback.deleteOrderRegistered(orderItem.id)
    }

    // Menu part



    interface ChangeCallback{
        fun changeRegistered()
        fun deleteOrderRegistered(orderId: String)
    }

}