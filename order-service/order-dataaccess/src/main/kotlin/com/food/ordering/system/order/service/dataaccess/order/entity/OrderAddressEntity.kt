package com.food.ordering.system.order.service.dataaccess.order.entity

import java.util.*
import javax.persistence.*


@Table(name = "order_address")
@Entity
data class OrderAddressEntity(
    @Id
    val id: UUID,
    val street: String,
    val postalCode: String,
    val city: String
) {
    @get:OneToOne(cascade = [CascadeType.ALL])
    @get:JoinColumn(name = "ORDER_ID")
    var order: OrderEntity
        get() = order

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as OrderAddressEntity
        return id == that.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}