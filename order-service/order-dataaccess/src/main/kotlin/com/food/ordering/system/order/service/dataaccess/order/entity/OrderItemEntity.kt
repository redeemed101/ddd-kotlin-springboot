package com.food.ordering.system.order.service.dataaccess.order.entity

import java.math.BigDecimal
import java.util.*
import javax.persistence.*


@Table(name = "order_items")
@Entity
data class OrderItemEntity(
    val productId: UUID,
    val price: BigDecimal,
    val quantity: Int,
    val subTotal: BigDecimal
) {
    @Id
    private val id: Long? = null

    @get:Id
    @get:ManyToOne(cascade = [CascadeType.ALL])
    @get:JoinColumn(name = "ORDER_ID")
    var order: OrderEntity
        get() = order
        set(value) {
            order = value
        }

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as OrderItemEntity
        return id == that.id && order!!.equals(that.order)
    }

    override fun hashCode(): Int {
        return Objects.hash(id, order)
    }
}