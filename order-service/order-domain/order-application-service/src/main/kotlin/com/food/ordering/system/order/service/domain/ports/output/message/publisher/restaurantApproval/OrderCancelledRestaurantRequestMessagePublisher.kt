package com.food.ordering.system.order.service.domain.ports.output.message.publisher.restaurantApproval

import com.food.ordering.system.domain.events.publisher.DomainEventPublisher
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent

interface OrderCancelledRestaurantRequestMessagePublisher : DomainEventPublisher<OrderPaidEvent> {
}