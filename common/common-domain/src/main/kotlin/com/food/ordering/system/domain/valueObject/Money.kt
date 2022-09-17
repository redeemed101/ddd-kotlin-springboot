package com.food.ordering.system.domain.valueObject

import java.math.BigDecimal
import java.math.RoundingMode

class Money constructor(amt: BigDecimal) {
    companion object{
        val ZERO : Money = Money(BigDecimal.ZERO)
    }
    private val amount : BigDecimal = amt
    fun get() = amount
    fun isGreaterThanZero() = amount != null && amount > BigDecimal.ZERO
    fun add(money: Money) = Money(setScale(amount.add(money.amount)))
    fun subtract(money: Money) = Money(setScale(amount.subtract(money.amount)))
    fun multiply(multiplier : BigDecimal) = Money(setScale(amount.multiply(multiplier)))
    private fun setScale(input: BigDecimal) = input.setScale(2, RoundingMode.HALF_EVEN)
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Money

        if (amount != other.amount) return false

        return true
    }

    override fun hashCode(): Int {
        return amount.hashCode()
    }


}