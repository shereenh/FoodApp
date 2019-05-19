package com.restaurant.foodapp.view.view.waiter.menu

class MenuItem (var number: String,
                var foodName: String,
                var quantity: String,
                var notes: String){

    constructor(number: String, foodName: String) : this(number, foodName, "0", "")
}