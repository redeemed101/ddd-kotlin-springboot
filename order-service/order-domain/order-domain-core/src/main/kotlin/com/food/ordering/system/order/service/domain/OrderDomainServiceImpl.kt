package com.food.ordering.system.order.service.domain

import com.food.ordering.system.order.service.domain.entity.Order
import com.food.ordering.system.order.service.domain.entity.Restaurant
import com.food.ordering.system.order.service.domain.event.OrderApprovedEvent
import com.food.ordering.system.order.service.domain.event.OrderCancelledEvent
import com.food.ordering.system.order.service.domain.event.OrderCreatedEvent
import com.food.ordering.system.order.service.domain.event.OrderPaidEvent
import com.food.ordering.system.order.service.domain.exception.OrderDomainException
import java.time.ZoneId
import java.time.ZonedDateTime



class OrderDomainServiceImpl : OrderDomainService {
    override fun validateAndInitiateOrder(order: Order, restaurant: Restaurant): OrderCreatedEvent {
        validateRestaurant(restaurant)
        setOrderProductInformation(order, restaurant)
        order.validateOrder()
        order.initializeOrder()

        return OrderCreatedEvent(order, ZonedDateTime.now(ZoneId.of("UTC")))
    }

    private fun setOrderProductInformation(order: Order, restaurant: Restaurant) {
         order.getItems().forEach { item ->
             restaurant.getProducts().forEach { product ->
              val currentProduct = item.getProduct()
                 currentProduct.updateWithConfirmedNameAndPrice(product.name,product.price)
             }
         }
    }
    private fun validateRestaurant(restaurant: Restaurant) {
       if(!restaurant.active){
          throw  OrderDomainException("Restaurant with ID : ${restaurant.id.get()} is not active")
       }
    }

    override fun payOrder(order: Order): OrderPaidEvent {
        order.pay()
        return OrderPaidEvent(order,ZonedDateTime.now(ZoneId.of("UTC")))
    }

    override fun approveOrder(order: Order) {
        order.approve()

    }

    override fun cancelOrderPayment(order: Order, failureMessages: List<String>): OrderCancelledEvent {
        order.initCancel()
        return OrderCancelledEvent(order,ZonedDateTime.now(ZoneId.of("UTC")))
    }

    override fun cancelOrder(order: Order) {
        order.cancel()
    }
}