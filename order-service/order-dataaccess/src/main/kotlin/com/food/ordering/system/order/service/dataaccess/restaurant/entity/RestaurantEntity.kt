package com.food.ordering.system.order.service.dataaccess.restaurant.entity

import java.math.BigDecimal
import java.util.*
import javax.persistence.Id

data class RestaurantEntity(
    @Id
    val id: UUID,
    val productName: String,
    val price : BigDecimal,
    val active : Boolean
)
