package com.food.ordering.system.order.service.domain

import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.mapper.OrderDataMapper
import com.food.ordering.system.order.service.domain.ports.input.service.OrderApplicationService
import com.food.ordering.system.order.service.domain.ports.output.repository.CustomerRepository
import com.food.ordering.system.order.service.domain.ports.output.repository.OrderRepository
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository
import org.junit.jupiter.api.TestInstance
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest(classes = [OrderTestConfiguration::class])
class OrderApplicationServiceTest {
    @get:Autowired
    private val orderApplicationService : OrderApplicationService
        get() = orderApplicationService

    @get:Autowired
    private val orderDataMapper: OrderDataMapper
        get() = orderDataMapper

    @get:Autowired
    private val orderRepository : OrderRepository
        get() = orderRepository

    @get:Autowired
    private val restaurantRepository : RestaurantRepository
        get() = restaurantRepository

    @get:Autowired
    private val customerRepository : CustomerRepository
        get() = customerRepository

    private val createOrderCommand : CreateOrderCommand
        get() = createOrderCommand

    private val createOrderCommandWrongPrice : CreateOrderCommand
        get() = createOrderCommandWrongPrice

    private val createOrderCommandWrongProductPrice : CreateOrderCommand
        get() = createOrderCommandWrongProductPrice
}