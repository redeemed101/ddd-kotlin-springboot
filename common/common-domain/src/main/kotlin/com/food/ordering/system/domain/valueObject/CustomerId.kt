package com.food.ordering.system.domain.valueObject

import java.util.*

data class CustomerId(val value : UUID): BaseId<UUID>(value)