package com.food.ordering.system.order.service.domain.entity

import com.food.ordering.system.domain.entity.AggregateRoot
import com.food.ordering.system.domain.valueObject.*
import com.food.ordering.system.order.service.domain.exception.OrderDomainException
import com.food.ordering.system.order.service.domain.valueObject.OrderItemId
import com.food.ordering.system.order.service.domain.valueObject.StreetAddress
import com.food.ordering.system.order.service.domain.valueObject.TrackingId
import java.util.*

data class Order(
    private val restaurantId: RestaurantId,
    private val customerId: CustomerId,
    private val streetAddress: StreetAddress,
    private val price :Money,
    private val items:List<OrderItem>,

) : AggregateRoot<OrderId>() {
    private var orderId : OrderId
    get() = orderId
    set(value) {
        orderId = value
    }
    var trackingId: TrackingId
    get() = trackingId
    set(value) {
        trackingId = value
    }
    var orderStatus: OrderStatus
    get() = orderStatus
    set(value) {
        orderStatus = value
    }

    private var failureMessages : List<String>
    get() = failureMessages
    set(value) { failureMessages = value}

    fun initializeOrder(){
         orderId = OrderId(UUID.randomUUID())
         trackingId = TrackingId(UUID.randomUUID())
         orderStatus = OrderStatus.PENDING
         initializeOrderItems()
    }
    private fun initializeOrderItems(){
        var itemId : Long = 1
        items.forEach { item ->
              item.initializeItem(orderId, OrderItemId( itemId++))
        }
    }

    fun validateOrder(){
        validateInitialOrder()
        validateTotalPrice()
        validateItemsPrice()
    }
    fun pay(){
        if (orderStatus != OrderStatus.PENDING){
            throw OrderDomainException("Order is not in correct state for pay operation")
        }
        orderStatus = OrderStatus.PAID
    }
    fun approve(){
        if (orderStatus != OrderStatus.PAID){
            throw OrderDomainException("Order is not in correct state for approve operation")
        }
        orderStatus = OrderStatus.APPROVED
    }
    fun initCancel(){
        if (orderStatus != OrderStatus.PAID){
            throw OrderDomainException("Order is not in correct state for cancelling operation")
        }
        orderStatus = OrderStatus.CANCELLING
    }
    fun cancel(){
        if (orderStatus != OrderStatus.CANCELLING && orderStatus != OrderStatus.PENDING){
            throw OrderDomainException("Order is not in correct state for cancel operation")
        }
        orderStatus = OrderStatus.CANCELLED
    }

    private fun validateItemsPrice(){
        val orderItemsTotal = items.stream().map { orderItem ->
            validateItemPrice(orderItem)
            orderItem.getPrice()
        }.reduce(Money.ZERO, Money::add)

        if(price != orderItemsTotal){
            throw OrderDomainException("Total Price : ${price.get()}" +
                    " is not equal to ${orderItemsTotal.get()}")
        }
    }

    private fun validateItemPrice(orderItem: OrderItem) {
      if(!orderItem.isPriceValid()){
          throw OrderDomainException("Item price is not valid")
      }
    }

    private fun validateTotalPrice(){
        if(price == null || !price.isGreaterThanZero() ){
            throw OrderDomainException("Total price must be greater than zero")
        }
    }
    private fun validateInitialOrder(){
        if(orderStatus != null || orderId != null){
            throw OrderDomainException("Order is not in a correct state for initialization")
        }
    }

    fun getRestaurantId() = restaurantId
    fun getCustomerId() = customerId
    fun getStreetAddress() = streetAddress
    fun getPrice() = price
    fun getItems() = items

}