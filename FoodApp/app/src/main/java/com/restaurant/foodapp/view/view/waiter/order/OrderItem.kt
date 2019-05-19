package com.restaurant.foodapp.view.view.waiter.order

class OrderItem (var id: String = "",
                 var table: String,
                 var state: Int) {

    constructor(id: String) : this(id, "New Table", 0)

    override fun equals(other: Any?): Boolean {
        if(this === other) return true
        
        if(other == null || this.javaClass != other.javaClass ) return false
        
        val item : OrderItem = other as OrderItem
        if(item.id == this.id) return true

        return false
            
        }

    override fun hashCode(): Int {
        return id.hashCode()
    }


}

/*
states:
        0 -> tab created
        1 -> table selected
        2 -> order made
        3 -> order confirmed
        4 -> order placed to chef & served
        5 -> bill

*/