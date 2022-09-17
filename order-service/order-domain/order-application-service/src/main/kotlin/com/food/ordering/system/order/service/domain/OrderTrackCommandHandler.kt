package com.food.ordering.system.order.service.domain

import com.food.ordering.system.order.service.domain.dto.track.TrackOrderQuery
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse
import com.food.ordering.system.order.service.domain.exception.OrderDomainException
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository
import com.food.ordering.system.order.service.domain.valueObject.TrackingId
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class OrderTrackCommandHandler constructor(
    private val orderRepository: OrderRepository,
    private val orderDataMapper: OrderDataMapper
) {
    @Transactional(readOnly = true)
    fun trackOrder(trackOrderQuery: TrackOrderQuery) : TrackOrderResponse{
       val order =  orderRepository.findByTrackingId(TrackingId( trackOrderQuery.orderTrackingId))?: throw OrderDomainException("order not found")
        return orderDataMapper.orderToTrackOrderResponse(order)
    }
}