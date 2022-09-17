package com.food.ordering.system.order.service.domain.ports.output.repository

import com.food.ordering.system.domain.valueObject.OrderId
import com.food.ordering.system.order.service.domain.entity.Order
import com.food.ordering.system.order.service.domain.valueObject.TrackingId

interface OrderRepository {
    fun save(order: Order) : Order?
    fun findByTrackingId(trackingId: TrackingId) : Order?

    fun findById(orderId: OrderId): Order?
}