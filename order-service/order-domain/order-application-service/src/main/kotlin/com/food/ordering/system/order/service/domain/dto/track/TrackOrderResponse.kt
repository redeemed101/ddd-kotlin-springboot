package com.food.ordering.system.order.service.domain.dto.track

import com.food.ordering.system.domain.valueObject.OrderStatus
import java.util.*

data class TrackOrderResponse(
    private val orderTrackingId : UUID,
    private val orderStatus: OrderStatus,
    private val failureMessages : List<String>

)