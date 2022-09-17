package com.food.ordering.system.order.service.dataaccess.order.repository

import com.food.ordering.system.order.service.dataaccess.order.entity.OrderEntity

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*


@Repository
interface OrderJpaRepository : JpaRepository<OrderEntity, UUID> {
    fun findByTrackingId(trackingId: UUID): OrderEntity?
}