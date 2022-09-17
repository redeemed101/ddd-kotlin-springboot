package com.food.ordering.system.order.service.domain.entity

import com.food.ordering.system.domain.entity.BaseEntity
import com.food.ordering.system.domain.valueObject.Money
import com.food.ordering.system.domain.valueObject.OrderId
import com.food.ordering.system.order.service.domain.valueObject.OrderItemId

data class OrderItem(

    private val product: Product,
    private val quantity: Int,
    private val price: Money,
    private val subTotal: Money

) : BaseEntity<OrderItemId>() {
    private var orderId : OrderId
    get() = orderId
    set(value) {
        orderId = value
    }

    fun initializeItem(orId: OrderId, orderItemId: OrderItemId){
        orderId = orId
        id = orderItemId
    }
    fun getProduct() = product
    fun getQuantity() = quantity
    fun getPrice() = price
    fun getSubTotal() = subTotal

    fun isPriceValid() = price.isGreaterThanZero()
            && price == product.price
            && price.multiply(quantity.toBigDecimal()) == subTotal

}