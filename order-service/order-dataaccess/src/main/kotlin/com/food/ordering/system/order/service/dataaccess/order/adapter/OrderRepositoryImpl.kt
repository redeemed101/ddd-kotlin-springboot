package com.food.ordering.system.order.service.dataaccess.order.adapter

import com.food.ordering.system.domain.valueObject.OrderId
import com.food.ordering.system.order.service.dataaccess.order.entity.OrderEntity
import com.food.ordering.system.order.service.dataaccess.order.mapper.OrderDataAccessMapper
import com.food.ordering.system.order.service.dataaccess.order.repository.OrderJpaRepository
import com.food.ordering.system.order.service.domain.entity.Order
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository
import com.food.ordering.system.order.service.domain.valueObject.TrackingId
import org.springframework.stereotype.Component


@Component
class OrderRepositoryImpl constructor(
    private val orderJpaRepository: OrderJpaRepository,
    private val orderDataAccessMapper : OrderDataAccessMapper
) : OrderRepository {

    override fun save(order: Order): Order? {
        return orderDataAccessMapper.orderEntityToOrder(
            orderJpaRepository
                .save(orderDataAccessMapper.orderToOrderEntity(order!!))
        )
    }

    override fun findById(orderId: OrderId): Order? {
        var orderOptional = orderJpaRepository.findById(orderId.value).map { it ->
            orderDataAccessMapper.orderEntityToOrder(
                it
            )
        }

       return orderOptional.orElse(null)
    }

    override fun findByTrackingId(trackingId: TrackingId): Order? {
        return orderJpaRepository.findByTrackingId(trackingId.id).let { it ->
            it?.let { it1 -> orderDataAccessMapper.orderEntityToOrder(it1) } ?: null

        }

    }
}