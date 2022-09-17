package com.food.ordering.system.order.service.domain.ports.input.message.listener.restaurantApproval

import com.food.ordering.system.order.service.domain.dto.message.RestaurantApprovalResponse

interface RestaurantApprovalResponseMessageListener {
    fun orderApproved(restaurantApprovalResponse: RestaurantApprovalResponse)
    fun orderRejected(restaurantApprovalResponse: RestaurantApprovalResponse)
}