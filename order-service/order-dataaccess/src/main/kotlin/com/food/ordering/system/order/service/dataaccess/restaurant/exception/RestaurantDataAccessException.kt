package com.food.ordering.system.order.service.dataaccess.restaurant.exception

import com.food.ordering.system.domain.exception.DomainException

class RestaurantDataAccessException : DomainException{
    constructor(msg : String) : super(msg)
}