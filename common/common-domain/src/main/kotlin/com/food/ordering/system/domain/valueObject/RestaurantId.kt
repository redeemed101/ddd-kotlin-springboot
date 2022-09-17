package com.food.ordering.system.domain.valueObject

import java.util.*

data class RestaurantId(val value : UUID): BaseId<UUID>(value)  {
}