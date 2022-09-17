package com.food.ordering.system.application.handler

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import java.util.stream.Collectors
import javax.validation.ConstraintViolation
import javax.validation.ConstraintViolationException
import javax.validation.ValidationException


@ControllerAdvice
open class GlobalExceptionHandler {
    @ResponseBody
    @ExceptionHandler(value = [Exception::class])
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    fun handleException(exception: Exception): ErrorDTO {

        return ErrorDTO(HttpStatus.INTERNAL_SERVER_ERROR.reasonPhrase,"Unexpected error!")

    }

    @ResponseBody
    @ExceptionHandler(value = [ValidationException::class])
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleException(validationException: ValidationException): ErrorDTO {
        val errorDTO: ErrorDTO
        errorDTO = if (validationException is ConstraintViolationException) {
            val violations = extractViolationsFromException(validationException as ConstraintViolationException)

            ErrorDTO(HttpStatus.BAD_REQUEST.reasonPhrase,violations)

        } else {
            val exceptionMessage: String = validationException.message!!

            ErrorDTO(HttpStatus.BAD_REQUEST.reasonPhrase,exceptionMessage)
        }
        return errorDTO
    }

    private fun extractViolationsFromException(validationException: ConstraintViolationException): String {
        return validationException.constraintViolations
            .stream()
            .map { obj: ConstraintViolation<*> -> obj.message }
            .collect(Collectors.joining("--"))
    }
}
