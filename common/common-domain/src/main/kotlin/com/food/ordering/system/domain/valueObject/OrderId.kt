package com.food.ordering.system.domain.valueObject

import java.util.UUID

data class OrderId(val value : UUID): BaseId<UUID>(value)