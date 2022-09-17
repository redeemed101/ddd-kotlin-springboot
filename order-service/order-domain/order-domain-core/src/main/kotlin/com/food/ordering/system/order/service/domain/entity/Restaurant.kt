package com.food.ordering.system.order.service.domain.entity

import com.food.ordering.system.domain.entity.AggregateRoot
import com.food.ordering.system.domain.valueObject.RestaurantId

data class Restaurant(private val restaurantId: RestaurantId,
                      private val products: List<Product>,
                      var active : Boolean
                      ) : AggregateRoot<RestaurantId>() {

    fun getProducts() = products
    fun getId() = restaurantId
}