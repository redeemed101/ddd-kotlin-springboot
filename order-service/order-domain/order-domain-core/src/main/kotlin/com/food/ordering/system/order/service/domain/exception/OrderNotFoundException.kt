package com.food.ordering.system.order.service.domain.exception

class OrderNotFoundException : OrderDomainException {
    constructor(msg: String) : super(msg)
}