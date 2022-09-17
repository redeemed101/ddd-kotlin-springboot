package com.food.ordering.system.order.service.dataaccess.restaurant.repository


import com.food.ordering.system.order.service.dataaccess.restaurant.entity.RestaurantEntity
import com.food.ordering.system.order.service.domain.entity.Product
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface RestaurantJpaRepository : JpaRepository<RestaurantEntity, UUID> {
    fun findByRestaurantIdAndProductIdIn(restaurantID : UUID,restaurantProducts : List<UUID>) :  Optional<List<RestaurantEntity>>
}