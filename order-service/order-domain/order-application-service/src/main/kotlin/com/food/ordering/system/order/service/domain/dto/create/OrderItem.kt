package com.food.ordering.system.order.service.domain.dto.create

import java.math.BigDecimal
import java.util.*

data class OrderItem(
    val orderId : UUID,
    val productId : UUID,
    val quantity : Integer,
    val price : BigDecimal,
    val subTotal: BigDecimal
    )
