package com.food.ordering.system.order.service.domain.exception

import com.food.ordering.system.domain.exception.DomainException

open class OrderDomainException : DomainException {
    constructor(msg: String) : super(msg)
    constructor(msg: String,cause: Throwable) : super(msg,cause)
}