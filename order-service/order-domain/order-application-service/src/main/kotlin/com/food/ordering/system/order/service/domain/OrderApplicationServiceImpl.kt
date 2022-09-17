package com.food.ordering.system.order.service.domain

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery
import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService
import org.springframework.stereotype.Service
import org.springframework.validation.annotation.Validated

@Validated
@Service
class OrderApplicationServiceImpl(
    private val orderCreatedCommandHandler: OrderCreatedCommandHandler,
    private val orderTrackCommandHandler: OrderTrackCommandHandler
) : OrderApplicationService {
    override fun createOrder(createOrderCommand: CreateOrderCommand)
        = orderCreatedCommandHandler.createOrder(createOrderCommand)

    override fun trackOrder(trackOrderQuery: TrackOrderQuery)
        = orderTrackCommandHandler.trackOrder(trackOrderQuery)
}