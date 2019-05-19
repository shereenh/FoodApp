package com.restaurant.foodapp.view.view.waiter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import com.restaurant.foodapp.R
import com.restaurant.foodapp.view.model.DataSource
import com.restaurant.foodapp.view.view.decorator.LinePagerIndicator
import com.restaurant.foodapp.view.view.waiter.order.OrderItem
import com.restaurant.foodapp.view.view.waiter.order.OrderPagerAdapter
import kotlinx.android.synthetic.main.activity_waiter.*

class WaiterActivity : AppCompatActivity() {

    lateinit var adapter : OrderPagerAdapter

    var dataList = arrayListOf<OrderItem>(DataSource.createOrder(),
        DataSource.createOrder(),DataSource.createOrder())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_waiter)

        init()

    }

    private fun init(){

        adapter = OrderPagerAdapter(dataList, this)
//        adapter.setOrders(dataList)
        orderRecycler.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        orderRecycler.addItemDecoration(LinePagerIndicator())
        val snapHelper: SnapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(orderRecycler)
        orderRecycler.adapter = adapter

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item!!.itemId){
            R.id.add-> {showToast("add selected")
            adapter.addOrder(DataSource.createOrder())}
            R.id.clear -> {showToast("clear selected")}
            R.id.orderHistory -> showToast("history selected")
            R.id.settings -> showToast("settings selected")
        }
        return true
    }

    private fun showToast(message: String){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}
