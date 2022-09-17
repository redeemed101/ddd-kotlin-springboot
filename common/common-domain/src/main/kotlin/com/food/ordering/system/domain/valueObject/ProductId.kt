package com.food.ordering.system.domain.valueObject

import java.util.*

data class ProductId(val v : UUID): BaseId<UUID>(v)