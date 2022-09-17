package com.food.ordering.system.order.service.domain.valueObject

import com.food.ordering.system.domain.valueObject.BaseId
import java.util.UUID

data class TrackingId(val id : UUID) : BaseId<UUID>(id)