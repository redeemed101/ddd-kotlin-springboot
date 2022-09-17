package com.food.ordering.system.order.service.domain

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent
import com.food.ordering.system.order.service.domain.exception.OrderDomainException
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class OrderCreateHelper constructor(
    private val orderDomainService: OrderDomainService,
    private val orderRepository: OrderRepository,
    private val customerRepository: CustomerRepository,
    private val restaurantRepository: RestaurantRepository,
    private val orderDataMapper: OrderDataMapper
) {
    @Transactional
    fun persistOrder(createOrderCommand: CreateOrderCommand) : OrderCreatedEvent{
        val customer = customerRepository.findCustomer(createOrderCommand.customerId) ?: throw OrderDomainException("Customer not found")
        val restaurant = restaurantRepository.findRestaurantInformation(
            orderDataMapper.createOrderCommandToRestaurant(createOrderCommand)
        ) ?: throw OrderDomainException("Restaurant not found")
        val order = orderDataMapper.createOrderCommandToOrder(createOrderCommand)
        val orderCreatedEvent = orderDomainService.validateAndInitiateOrder(order, restaurant)
        orderRepository.save(order)
        return  orderCreatedEvent
    }
}