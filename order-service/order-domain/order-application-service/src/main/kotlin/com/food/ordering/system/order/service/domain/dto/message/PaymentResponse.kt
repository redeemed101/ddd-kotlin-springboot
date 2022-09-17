package com.food.ordering.system.order.service.domain.dto.message

import java.math.BigDecimal
import java.time.Instant

class PaymentResponse{
    private var id : String
        get() = id
        set(value) {
            id = value
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
    private var paymentId : String
        get() = paymentId
        set(value) {
            paymentId = value
        }
    private var customerId : String
        get() = customerId
        set(value) {
            customerId = value
        }
    private var price : BigDecimal
        get() = price
        set(value) {
            price = value
        }
    private var createdAt : Instant
        get() = createdAt
        set(value) {
            createdAt = value
        }
    private var paymentStatus : PaymentStatus
        get() = paymentStatus
        set(value) {
            paymentStatus = value
        }
    private var failureMessages : List<String>
        get() = failureMessages
        set(value) {
            failureMessages = value
        }


}