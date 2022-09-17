package com.food.ordering.system.order.service.application.exception.handler

import com.food.ordering.system.application.handler.ErrorDTO
import com.food.ordering.system.application.handler.GlobalExceptionHandler
import com.food.ordering.system.order.service.domain.exception.OrderDomainException
import com.food.ordering.system.order.service.domain.exception.OrderNotFoundException
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus


@ControllerAdvice
class OrderGlobalExceptionHandler : GlobalExceptionHandler() {
    @ResponseBody
    @ExceptionHandler(value = [OrderDomainException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleException(orderDomainException: OrderDomainException): ErrorDTO {

        return ErrorDTO(HttpStatus.BAD_REQUEST.reasonPhrase,orderDomainException.message!!)

    }

    @ResponseBody
    @ExceptionHandler(value = [OrderNotFoundException::class])
    @ResponseStatus(HttpStatus.NOT_FOUND)
    fun handleException(orderNotFoundException: OrderNotFoundException): ErrorDTO {

        return ErrorDTO(HttpStatus.NOT_FOUND.reasonPhrase,orderNotFoundException.message!!)

    }
}