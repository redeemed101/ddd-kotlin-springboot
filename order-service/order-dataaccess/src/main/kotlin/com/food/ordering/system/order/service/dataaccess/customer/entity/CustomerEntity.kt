package com.food.ordering.system.order.service.dataaccess.customer.entity

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table

@Table(name = "order_customer_m_view", schema = "customer")
@Entity
data class CustomerEntity(
    @Id
    val id: UUID
) {

}
