package com.food.ordering.system.order.service.dataaccess.order.entity

import com.food.ordering.system.domain.valueObject.OrderStatus
import java.math.BigDecimal
import java.util.*
import javax.persistence.*


@Table(name = "orders")
@Entity
data class OrderEntity(
    @Id
    val id: UUID,
    val customerId: UUID,
    val restaurantId: UUID,
    val trackingId: UUID,
    val price: BigDecimal,
    @Enumerated(EnumType.STRING)
    val orderStatus: OrderStatus,
    val failureMessages: String,
    @OneToOne(mappedBy = "order", cascade = [CascadeType.ALL])
    val address: OrderAddressEntity,
    @OneToMany(mappedBy = "order", cascade = [CascadeType.ALL])
    val items: List<OrderItemEntity>
) {

    override fun equals(o: Any?): Boolean {
        if (this === o) return true
        if (o == null || javaClass != o.javaClass) return false
        val that = o as OrderEntity
        return id == that.id
    }

    override fun hashCode(): Int {
        return Objects.hash(id)
    }
}