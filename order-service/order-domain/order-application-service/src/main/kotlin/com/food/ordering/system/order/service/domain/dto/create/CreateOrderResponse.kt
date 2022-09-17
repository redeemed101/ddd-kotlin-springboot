package com.food.ordering.system.order.service.domain.dto.create

import com.food.ordering.system.domain.valueObject.OrderStatus
import java.util.*

data class CreateOrderResponse(
    private val orderTrackingId : UUID,
    private val orderStatus : OrderStatus,
    private val message : String
)