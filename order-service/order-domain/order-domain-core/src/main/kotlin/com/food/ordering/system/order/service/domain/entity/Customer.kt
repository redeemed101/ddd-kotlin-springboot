package com.food.ordering.system.order.service.domain.entity

import com.food.ordering.system.domain.entity.AggregateRoot
import com.food.ordering.system.domain.valueObject.CustomerId

data class Customer(
    val customerId: CustomerId
) : AggregateRoot<CustomerId>() {
}