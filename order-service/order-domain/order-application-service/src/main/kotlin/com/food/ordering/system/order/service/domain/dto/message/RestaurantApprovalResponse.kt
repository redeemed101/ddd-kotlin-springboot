package com.food.ordering.system.order.service.domain.dto.message

import java.time.Instant

class RestaurantApprovalResponse {
    private var id : String
        get() = id
        set(value) {
            id = value
        }
    private var restaurantId : String
        get() = restaurantId
        set(value) {
            restaurantId = value
        }
    private var sagaId : String
        get() = sagaId
        set(value) {
            sagaId = value
        }
    private var orderId : String
        get() = orderId
        set(value) {
            orderId = value
        }
    private var createdAt : Instant
        get() = createdAt
        set(value) {
            createdAt = value
        }
    private var orderApprovalStatus : OrderApprovalStatus
        get() = orderApprovalStatus
        set(value) {
            orderApprovalStatus = value
        }
}