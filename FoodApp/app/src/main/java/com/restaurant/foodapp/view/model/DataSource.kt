package com.restaurant.foodapp.view.model

import com.restaurant.foodapp.view.view.waiter.menu.MenuItem
import com.restaurant.foodapp.view.view.waiter.order.OrderItem

object DataSource {

    fun createOrder(): OrderItem {
        val randomId = (0..Long.MAX_VALUE).random()
        return OrderItem(randomId.toString())
    }

    val tableList = arrayListOf("Select Table", "Table 1", "Table 2", "Table 3", "Table 4")

    val startersVegList = arrayListOf<MenuItem>(
        MenuItem("1.","Mushroom Manchurian"),
        MenuItem("2.","Veg Manchurian"), MenuItem("3.","Gobi Chilli")
    )

    val startersNonVegList = arrayListOf(MenuItem("1.","Chicken 65"),
        MenuItem("2.","Chilli Chicken"), MenuItem("3.","Chicken Kebab")
    )

    val sandwichList = arrayListOf(MenuItem("1.","Veg Sandwich"),
        MenuItem("2.","Chicken Sandwich"), MenuItem("3.","Stuffed Veg Sandwich")
    )

    val mainCourseVegList = arrayListOf(MenuItem("1.","Kadai Veg"),
        MenuItem("2.","Chana Masala"),
        MenuItem("3.","Green Peas Masala"))
}