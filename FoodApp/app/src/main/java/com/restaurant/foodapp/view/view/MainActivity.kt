package com.restaurant.foodapp.view.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.restaurant.foodapp.R
import com.restaurant.foodapp.view.view.waiter.WaiterActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        waiterButton.setOnClickListener{
            startActivity(Intent(this@MainActivity, WaiterActivity::class.java))
        }
    }

}
