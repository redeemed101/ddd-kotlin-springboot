package com.food.ordering.system.order.service.dataaccess.order.entity

import java.io.Serializable
import java.util.*


class OrderItemEntityId : Serializable {
    private val id: Long? = null
    private val order: OrderEntity? = null
    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as OrderItemEntityId
        return id == that.id && order!!.equals(that.order)
    }

    override fun hashCode(): Int {
        return Objects.hash(id, order)
    }
}