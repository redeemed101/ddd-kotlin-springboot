package com.food.ordering.system.domain.exception

open class DomainException: RuntimeException {

   constructor(msg: String) : super(msg)
   constructor(msg: String,cause: Throwable) : super(msg,cause)
}