package com.food.ordering.system.order.service.domain.mapper

import com.food.ordering.system.domain.valueObject.CustomerId
import com.food.ordering.system.domain.valueObject.Money
import com.food.ordering.system.domain.valueObject.ProductId
import com.food.ordering.system.domain.valueObject.RestaurantId
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderCommand
import com.food.ordering.system.order.service.domain.dto.create.CreateOrderResponse
import com.food.ordering.system.order.service.domain.dto.track.TrackOrderResponse
import com.food.ordering.system.order.service.domain.entity.Order
import com.food.ordering.system.order.service.domain.entity.OrderItem
import com.food.ordering.system.order.service.domain.entity.Product
import com.food.ordering.system.order.service.domain.entity.Restaurant
import com.food.ordering.system.order.service.domain.valueObject.StreetAddress
import org.springframework.stereotype.Component
import java.util.*


@Component
class OrderDataMapper {
    fun createOrderCommandToRestaurant(createOrderCommand: CreateOrderCommand) : Restaurant{
        return Restaurant(
            RestaurantId( createOrderCommand.restaurantId),
            createOrderCommand.items.map{ item ->
                Product(ProductId(item.productId))
            }
        )
    }
    fun orderToCreateOrderResponse(order: Order, message:String) : CreateOrderResponse{
        return CreateOrderResponse(
            orderTrackingId = order.trackingId.id,
            orderStatus = order.orderStatus,
            message = message
        )
    }
    fun orderToTrackOrderResponse(order: Order) : TrackOrderResponse{
        return TrackOrderResponse(
            orderTrackingId = order.trackingId.id,
            orderStatus = order.orderStatus,
            failureMessages = emptyList()
        )
    }
    fun createOrderCommandToOrder(createOrderCommand: CreateOrderCommand) : Order {
        return Order(
            restaurantId = RestaurantId(createOrderCommand.restaurantId),
            customerId = CustomerId(createOrderCommand.customerId),
            streetAddress = StreetAddress(
                id = UUID.randomUUID(),
                street = createOrderCommand.orderAddress.street,
                postalCode = createOrderCommand.orderAddress.postalCode,
                city = createOrderCommand.orderAddress.city
            ),
            price = Money(createOrderCommand.price),
            items = createOrderCommand.items.map { item ->
                OrderItem(product = Product(ProductId(item.productId)),
                         quantity = item.quantity.toInt(),
                         price = Money(item.price),
                        subTotal = Money(item.subTotal)
                )
            }
        )
    }
}