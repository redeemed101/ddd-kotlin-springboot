package com.food.ordering.system.order.service.domain.event

import com.food.ordering.system.domain.events.DomainEvent
import com.food.ordering.system.order.service.domain.entity.Order
import java.time.ZonedDateTime

class OrderPaidEvent constructor(
    order: Order,
    createdAt : ZonedDateTime
) : OrderEvent(order,createdAt) {

}