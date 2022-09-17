package com.food.ordering.system.order.service.domain.entity

import com.food.ordering.system.domain.entity.AggregateRoot
import com.food.ordering.system.domain.valueObject.RestaurantId

data class Restaurant(private val restaurantId: RestaurantId,
                      private val products: List<Product>) : AggregateRoot<RestaurantId>() {
        var active : Boolean
        get() = active
        set(value) {
            active = value
        }
    fun getProducts() = products
    fun getId() = restaurantId
}