package com.food.ordering.system.order.service.dataaccess.order.mapper

import com.food.ordering.system.domain.valueObject.*
import com.food.ordering.system.order.service.dataaccess.order.entity.OrderAddressEntity
import com.food.ordering.system.order.service.dataaccess.order.entity.OrderEntity
import com.food.ordering.system.order.service.dataaccess.order.entity.OrderItemEntity
import com.food.ordering.system.order.service.domain.entity.Order
import com.food.ordering.system.order.service.domain.entity.OrderItem
import com.food.ordering.system.order.service.domain.entity.Product
import com.food.ordering.system.order.service.domain.valueObject.StreetAddress
import com.food.ordering.system.order.service.domain.valueObject.TrackingId
import org.springframework.stereotype.Component


@Component
class OrderDataAccessMapper {
    fun orderToOrderEntity(order: Order): OrderEntity {
        var orderEntity: OrderEntity = OrderEntity(order.id.value,
             order.getCustomerId().value,
            order.getRestaurantId().value,
            order.trackingId.id,
            order.getPrice().get(),
            order.orderStatus,
            "",
            deliveryAddressToAddressEntity(order.getStreetAddress()),
            orderItemsToOrderItemEntities(order.getItems())
         )

        orderEntity.address.order = orderEntity
        orderEntity.items.forEach { orderItemEntity ->
            orderItemEntity.order = orderEntity
        }
        return orderEntity
    }

    fun orderEntityToOrder(orderEntity: OrderEntity): Order {
        var order = Order(
            RestaurantId(orderEntity.restaurantId),
            CustomerId(orderEntity.customerId),
            addressEntityToDeliveryAddress(orderEntity.address),
            Money(orderEntity.price),
            orderItemEntitiesToOrderItems(orderEntity.items))
            order.trackingId = TrackingId(orderEntity.trackingId)
            order.orderStatus = orderEntity.orderStatus
            order.id = OrderId(orderEntity.id)

        return order

    }

    private fun orderItemEntitiesToOrderItems(items: List<OrderItemEntity>): List<OrderItem> {
        return items.map { it ->
            OrderItem(
                Product(ProductId(it.productId)),
                it.quantity,
                Money(it.price),
                Money(it.subTotal)

            )
        }

    }

    private fun addressEntityToDeliveryAddress(address: OrderAddressEntity): StreetAddress {
        return StreetAddress(
            address.id,
            address.street,
            address.postalCode,
            address.city
        )
    }

    private fun orderItemsToOrderItemEntities(items: List<OrderItem>): List<OrderItemEntity> {
        return items.map { it ->

                var order = OrderItemEntity(
                    it.getProduct().id.v,
                    it.getPrice().get(),
                    it.getQuantity(),
                    it.getSubTotal().get())

                order

        }

    }

    private fun deliveryAddressToAddressEntity( deliveryAddress: StreetAddress): OrderAddressEntity {
        return OrderAddressEntity(
            deliveryAddress.getId(),
            deliveryAddress.getStreet(),
            deliveryAddress.getPostalCode(),
            deliveryAddress.getCity())

    }
}