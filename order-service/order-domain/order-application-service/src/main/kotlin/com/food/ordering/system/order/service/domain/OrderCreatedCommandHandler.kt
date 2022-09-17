package com.food.ordering.system.order.service.domain

import com.food.ordering.system.domain.exception.DomainException
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse
import com.food.ordering.system.order.service.domain.exception.OrderDomainException
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper
import com.food.ordering.system.order.service.domain.ports.output.message.publisher.payment.OrderCreatedPaymentRequestMessagePublisher
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class OrderCreatedCommandHandler(
    private val orderCreateHelper: OrderCreateHelper,
    private val orderDataMapper: OrderDataMapper,
    private val orderCreatedPaymentRequestMessagePublisher: OrderCreatedPaymentRequestMessagePublisher,
) {
    @Transactional
    fun createOrder(createOrderCommand: CreateOrderCommand) : CreateOrderResponse{
       val event = orderCreateHelper.persistOrder(createOrderCommand)
       orderCreatedPaymentRequestMessagePublisher.publish(event)
       return orderDataMapper.orderToCreateOrderResponse(event.getOrder(), "Order successfully created")
    }
}