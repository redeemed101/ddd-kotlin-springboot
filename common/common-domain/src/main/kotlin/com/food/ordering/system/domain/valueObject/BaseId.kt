package com.food.ordering.system.domain.valueObject

abstract class BaseId<T> protected constructor(va : T) {
    private val v: T = va
    fun get()  = v
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseId<*>

        if (v != other.v) return false

        return true
    }

    override fun hashCode(): Int {
        return v?.hashCode() ?: 0
    }

}