package com.food.ordering.system.order.service.domain.valueObject

import com.food.ordering.system.domain.valueObject.BaseId

data class OrderItemId(val id : Long) : BaseId<Long>(id)
