package com.food.ordering.system.order.service.dataaccess.restaurant.mapper

import com.food.ordering.system.domain.valueObject.Money
import com.food.ordering.system.domain.valueObject.ProductId
import com.food.ordering.system.domain.valueObject.RestaurantId
import com.food.ordering.system.order.service.dataaccess.restaurant.entity.RestaurantEntity
import com.food.ordering.system.order.service.dataaccess.restaurant.exception.RestaurantDataAccessException
import com.food.ordering.system.order.service.domain.entity.Product
import com.food.ordering.system.order.service.domain.entity.Restaurant
import org.springframework.stereotype.Component
import java.util.*
import java.util.function.Function
import java.util.function.Supplier
import java.util.stream.Collectors


@Component
class RestaurantDataAccessMapper {
    fun restaurantToRestaurantProducts(restaurant: Restaurant): List<UUID> {
        return restaurant.getProducts().map { prod ->
                prod.id.v
        }
    }

    fun restaurantEntityToRestaurant(restaurantEntities: List<RestaurantEntity>): Restaurant {
        val restaurantEntity: RestaurantEntity = restaurantEntities.stream().findFirst().orElseThrow {
            RestaurantDataAccessException(
                "Restaurant could not be found!"
            )
        }
        val restaurantProducts: List<Product> =
            restaurantEntities.map{ entity ->
                Product(
                    ProductId(entity.id),
                    entity.productName,
                    Money(entity.price)
                )
            }
        return Restaurant(
            RestaurantId(restaurantEntity.id),
            restaurantProducts,
            restaurantEntity.active)
    }
}