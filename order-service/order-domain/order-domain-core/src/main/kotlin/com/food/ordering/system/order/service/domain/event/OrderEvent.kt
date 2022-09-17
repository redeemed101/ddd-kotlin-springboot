package com.food.ordering.system.order.service.domain.event

import com.food.ordering.system.domain.events.DomainEvent
import com.food.ordering.system.order.service.domain.entity.Order
import java.time.ZonedDateTime

abstract class OrderEvent(
    private val order: Order,
    private val createdAt : ZonedDateTime
) : DomainEvent<Order> {
    fun getOrder() = order
    fun getCreatedAt() = createdAt
}