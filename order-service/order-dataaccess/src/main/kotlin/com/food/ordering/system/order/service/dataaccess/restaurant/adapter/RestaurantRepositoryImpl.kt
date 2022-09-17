package com.food.ordering.system.order.service.dataaccess.restaurant.adapter

import com.food.ordering.system.order.service.dataaccess.restaurant.entity.RestaurantEntity
import com.food.ordering.system.order.service.dataaccess.restaurant.mapper.RestaurantDataAccessMapper
import com.food.ordering.system.order.service.dataaccess.restaurant.repository.RestaurantJpaRepository
import com.food.ordering.system.order.service.domain.entity.Restaurant
import com.food.ordering.system.order.service.domain.ports.output.repository.RestaurantRepository
import org.springframework.stereotype.Component
import java.util.*
import kotlin.jvm.optionals.getOrNull


@Component
class RestaurantRepositoryImpl(
    private val restaurantJpaRepository: RestaurantJpaRepository,
    private val restaurantDataAccessMapper: RestaurantDataAccessMapper
) : RestaurantRepository {
    override fun findRestaurantInformation(restaurant: Restaurant): Restaurant? {
        val restaurantProducts: List<UUID> = restaurantDataAccessMapper.restaurantToRestaurantProducts(restaurant)

        val restaurantEntities: List<RestaurantEntity>? = restaurantJpaRepository.findByRestaurantIdAndProductIdIn(
                restaurant.getId().value,
                restaurantProducts
            ).orElse(null)
        return restaurantEntities?.let {
            restaurantDataAccessMapper.restaurantEntityToRestaurant(
                it
            )
        }

    }
}