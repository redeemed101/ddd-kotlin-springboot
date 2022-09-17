package com.food.ordering.system.domain.entity

abstract class BaseEntity<ID> {
   var id : ID
   get()  = id
   set(value) { id = value}
   override fun equals(other: Any?): Boolean {

        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as BaseEntity<*>

        if (id != other.id) return false

        return true
    }

    override fun hashCode(): Int {
        return id?.hashCode() ?: 0
    }

}